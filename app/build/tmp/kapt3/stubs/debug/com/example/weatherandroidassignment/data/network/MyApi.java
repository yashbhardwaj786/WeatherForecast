package com.example.weatherandroidassignment.data.network;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ?\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00062\b\b\u0001\u0010\b\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/weatherandroidassignment/data/network/MyApi;", "", "getWeatherDetails", "Lretrofit2/Response;", "Lcom/example/weatherandroidassignment/data/network/response/WeatherResponse;", "cityName", "", "units", "api_key", "count", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public abstract interface MyApi {
    public static final com.example.weatherandroidassignment.data.network.MyApi.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "forecast")
    public abstract java.lang.Object getWeatherDetails(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "q")
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "units")
    java.lang.String units, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "appid")
    java.lang.String api_key, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Query(value = "cnt")
    java.lang.String count, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.weatherandroidassignment.data.network.response.WeatherResponse>> p4);
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0011\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002\u00a8\u0006\u0007"}, d2 = {"Lcom/example/weatherandroidassignment/data/network/MyApi$Companion;", "", "()V", "invoke", "Lcom/example/weatherandroidassignment/data/network/MyApi;", "networkConnectionInterceptor", "Lcom/example/weatherandroidassignment/data/network/NetworkConnectionInterceptor;", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.weatherandroidassignment.data.network.MyApi invoke(@org.jetbrains.annotations.NotNull()
        com.example.weatherandroidassignment.data.network.NetworkConnectionInterceptor networkConnectionInterceptor) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}