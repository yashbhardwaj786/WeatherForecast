package com.example.weatherandroidassignment.ui.activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weatherandroidassignment.R
import com.example.weatherandroidassignment.databinding.ActivityMainBinding
import com.example.weatherandroidassignment.ui.activity.SplashActivity.Companion.CITY_NAME
import com.example.weatherandroidassignment.ui.modelfactory.MainViewModelFactory
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel
import com.example.weatherandroidassignment.utils.Coroutines
import com.example.weatherandroidassignment.utils.DateFormat
import com.example.weatherandroidassignment.utils.getSimpleDateFormat
import com.example.weatherandroidassignment.utils.getTimeInHours
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.*

class MainActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()
    private lateinit var mainViewModel: MainViewModel
    private var isSameCity = false
    private var cityName = ""
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel =
            ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.viewModel = mainViewModel

        setToolBar(false, "Weather Forecast")

        intent.getStringExtra(CITY_NAME)?.let {
            cityName = it
            mainViewModel.isSameLocation.set(isSameCity)
        }

        makeAPICall()

        mainViewModel.onFailure.observe(this, Observer {
            Coroutines.main {
                binding.errorModel = mainViewModel.errorModel
            }
        })

        mainViewModel.onStart.observe(this, Observer {
            mainViewModel.shimmerVisible.set(true)
            mainViewModel.onError.set(false)
        })

        mainViewModel.onSuccess.observe(this, Observer {
            mainViewModel.onError.set(false)
            var weatherResult = it.list[0]
            binding.data = weatherResult
            binding.cityData = it.city
            val c: Date = Calendar.getInstance().time

            val df = getSimpleDateFormat(DateFormat.USER_READABLE_WITH_TIME)
            df?.let { sdf->
                binding.date = sdf.format(c)
            }

            weatherResult.sunrise.let { sunriseTime->
                val sunRISETTime = getTimeInHours(sunriseTime*1000, DateFormat.TWELVE_FOUR_HOURS)
                binding.sunriseTime = sunRISETTime
            }

            weatherResult.sunset.let { sunsetTime->
                val sunsetTTime = getTimeInHours(sunsetTime*1000, DateFormat.TWELVE_FOUR_HOURS)
                binding.sunsetTime = sunsetTTime
            }

            weatherResult.weather.let { weatherData->
                if (weatherData.isNotEmpty()) {
                    weatherData[0].description.let { status ->
                        binding.status = status

                    }
                }
            }

        })
    }

    private fun makeAPICall() {
        mainViewModel.apiCallToGetWeatherData(cityName)
    }


}