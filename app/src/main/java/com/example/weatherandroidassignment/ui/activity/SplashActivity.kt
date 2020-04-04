package com.example.weatherandroidassignment.ui.activity

import android.Manifest
import android.content.Intent
import android.content.IntentSender
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.os.Build
import android.os.Bundle
import android.os.Handler
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.example.weatherandroidassignment.R
import com.example.weatherandroidassignment.utils.toast
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.*
import java.util.*

class SplashActivity : BaseActivity(), LocationListener,
    GoogleApiClient.ConnectionCallbacks,
    GoogleApiClient.OnConnectionFailedListener {

    private val GPS_REQUEST_CODE = 1000
    val REQUEST_LOCATION = 105
    var location: Location? = null
    private var mLocationCallback: LocationCallback? = null
    var lat = 0.0
    var lon = 0.0
    private var googleApiClient: GoogleApiClient? = null
    private var locationRequest: LocationRequest? = null
    private var locationUpdate = MutableLiveData<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mLocationCallback = object : LocationCallback() {
            override fun onLocationResult(locationResult: LocationResult) {
                for (location in locationResult.locations) {
                    lat = location.latitude
                    lon = location.longitude
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkPermission()
        } else {
            enableGPS()
        }

        locationUpdate.observe(this, androidx.lifecycle.Observer {
            val geoCoder = Geocoder(this, Locale.getDefault())
            try {
                val addresses: List<Address> =
                    geoCoder.getFromLocation(lat, lon, 1)
                if (addresses.isNotEmpty()) {
                    val splashTimeHandler = Handler()
                    val finalizer = Runnable {
                        Intent(this, MainActivity::class.java).also {
                            it.putExtra(CITY_NAME, addresses[0].locality)
                            startActivity(it)
                            finish()
                        }
                    }
                    splashTimeHandler.postDelayed(finalizer, 2000)

                } else {
                    enableGPS()
                }
            } catch (ex: java.lang.Exception) {
                enableGPS()
            }

        })

    }

    override fun onLocationChanged(location: Location?) {
        if (location != null) {
            lat = location.latitude
            lon = location.longitude
            LocationServices.FusedLocationApi.removeLocationUpdates(
                googleApiClient,
                this as com.google.android.gms.location.LocationListener
            )
            locationUpdate.postValue("Location Update")
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {

    }

    override fun onProviderEnabled(p0: String?) {

    }

    override fun onProviderDisabled(p0: String?) {

    }

    override fun onConnected(p0: Bundle?) {

    }

    override fun onConnectionSuspended(p0: Int) {

    }

    override fun onConnectionFailed(p0: ConnectionResult) {

    }

    private fun checkPermission() {
        if (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            val permissions =
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
            ActivityCompat.requestPermissions(
                this,
                permissions,
                REQUEST_LOCATION
            )
        } else {
            enableGPS()
        }
    }

    private fun registerForLocationListener() {
        try {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                checkPermission()
                return
            }
            location = LocationServices.FusedLocationApi.getLastLocation(googleApiClient)
            if (location != null) {
                lat = location!!.latitude
                lon = location!!.longitude
                locationUpdate.postValue("Location Update")

            } else {
                LocationServices.FusedLocationApi.requestLocationUpdates(
                    googleApiClient,
                    locationRequest,
                    mLocationCallback,
                    null
                )
                locationUpdate.postValue("Location Update")
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun enableGPS() {
        if (googleApiClient == null) {
            googleApiClient = GoogleApiClient.Builder(this)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build()
            googleApiClient?.connect()
        }
        if (!googleApiClient!!.isConnected) googleApiClient!!.connect()
        locationRequest = LocationRequest.create()
        locationRequest?.priority = LocationRequest.PRIORITY_HIGH_ACCURACY
        locationRequest?.interval = 1000
        locationRequest?.fastestInterval = 1000
        val builder = LocationSettingsRequest.Builder()
            .addLocationRequest(locationRequest!!)

        builder.setAlwaysShow(true)

        val result =
            LocationServices.SettingsApi
                .checkLocationSettings(googleApiClient, builder.build())
        result.setResultCallback { result ->
            val status = result.status
            when (status.statusCode) {
                LocationSettingsStatusCodes.SUCCESS ->
                    registerForLocationListener()
                LocationSettingsStatusCodes.RESOLUTION_REQUIRED ->
                    try {
                        status.startResolutionForResult(this, GPS_REQUEST_CODE)
                    } catch (e: IntentSender.SendIntentException) { // Ignore the error.
                    }
                LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE -> {
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_OK) {
            registerForLocationListener()
        } else if (resultCode == RESULT_CANCELED) {
            toast(resources.getString(R.string.location_denied_message))
            finish()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == REQUEST_LOCATION) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                enableGPS()
            } else {
                toast("Go to Settings & enable Location permission and try again")
                finish()
            }
        }
    }


    companion object {
        const val CITY_NAME = "city_name"
    }

}