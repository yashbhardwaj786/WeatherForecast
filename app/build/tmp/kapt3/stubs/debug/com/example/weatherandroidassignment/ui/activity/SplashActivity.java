package com.example.weatherandroidassignment.ui.activity;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\"\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010\'H\u0014J\u0012\u0010(\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010+\u001a\u00020!2\u0006\u0010)\u001a\u00020,H\u0016J\u0010\u0010-\u001a\u00020!2\u0006\u0010)\u001a\u00020\u0007H\u0016J\u0012\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010*H\u0014J\u0012\u00100\u001a\u00020!2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u00101\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u000102H\u0016J\u0012\u00103\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u000102H\u0016J-\u00104\u001a\u00020!2\u0006\u0010$\u001a\u00020\u00072\u000e\u00105\u001a\n\u0012\u0006\u0012\u0004\u0018\u000102062\u0006\u00107\u001a\u000208H\u0016\u00a2\u0006\u0002\u00109J$\u0010:\u001a\u00020!2\b\u0010)\u001a\u0004\u0018\u0001022\u0006\u0010;\u001a\u00020\u00072\b\u0010<\u001a\u0004\u0018\u00010*H\u0016J\b\u0010=\u001a\u00020!H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\u0007X\u0086D\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0010\"\u0004\b\u001d\u0010\u0012R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006>"}, d2 = {"Lcom/example/weatherandroidassignment/ui/activity/SplashActivity;", "Lcom/example/weatherandroidassignment/ui/activity/BaseActivity;", "Landroid/location/LocationListener;", "Lcom/google/android/gms/common/api/GoogleApiClient$ConnectionCallbacks;", "Lcom/google/android/gms/common/api/GoogleApiClient$OnConnectionFailedListener;", "()V", "GPS_REQUEST_CODE", "", "REQUEST_LOCATION", "getREQUEST_LOCATION", "()I", "googleApiClient", "Lcom/google/android/gms/common/api/GoogleApiClient;", "lat", "", "getLat", "()D", "setLat", "(D)V", "location", "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "setLocation", "(Landroid/location/Location;)V", "locationRequest", "Lcom/google/android/gms/location/LocationRequest;", "lon", "getLon", "setLon", "mLocationCallback", "Lcom/google/android/gms/location/LocationCallback;", "checkPermission", "", "enableGPS", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConnected", "p0", "Landroid/os/Bundle;", "onConnectionFailed", "Lcom/google/android/gms/common/ConnectionResult;", "onConnectionSuspended", "onCreate", "savedInstanceState", "onLocationChanged", "onProviderDisabled", "", "onProviderEnabled", "onRequestPermissionsResult", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onStatusChanged", "p1", "p2", "registerForLocationListener", "app_debug"})
public final class SplashActivity extends com.example.weatherandroidassignment.ui.activity.BaseActivity implements android.location.LocationListener, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener {
    private final int GPS_REQUEST_CODE = 1000;
    private final int REQUEST_LOCATION = 105;
    @org.jetbrains.annotations.Nullable()
    private android.location.Location location;
    private com.google.android.gms.location.LocationCallback mLocationCallback;
    private double lat;
    private double lon;
    private com.google.android.gms.common.api.GoogleApiClient googleApiClient;
    private com.google.android.gms.location.LocationRequest locationRequest;
    private java.util.HashMap _$_findViewCache;
    
    public final int getREQUEST_LOCATION() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final android.location.Location getLocation() {
        return null;
    }
    
    public final void setLocation(@org.jetbrains.annotations.Nullable()
    android.location.Location p0) {
    }
    
    public final double getLat() {
        return 0.0;
    }
    
    public final void setLat(double p0) {
    }
    
    public final double getLon() {
        return 0.0;
    }
    
    public final void setLon(double p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onLocationChanged(@org.jetbrains.annotations.Nullable()
    android.location.Location location) {
    }
    
    @java.lang.Override()
    public void onStatusChanged(@org.jetbrains.annotations.Nullable()
    java.lang.String p0, int p1, @org.jetbrains.annotations.Nullable()
    android.os.Bundle p2) {
    }
    
    @java.lang.Override()
    public void onProviderEnabled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onProviderDisabled(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    public void onConnected(@org.jetbrains.annotations.Nullable()
    android.os.Bundle p0) {
    }
    
    @java.lang.Override()
    public void onConnectionSuspended(int p0) {
    }
    
    @java.lang.Override()
    public void onConnectionFailed(@org.jetbrains.annotations.NotNull()
    com.google.android.gms.common.ConnectionResult p0) {
    }
    
    private final void checkPermission() {
    }
    
    private final void registerForLocationListener() {
    }
    
    private final void enableGPS() {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    public SplashActivity() {
        super();
    }
}