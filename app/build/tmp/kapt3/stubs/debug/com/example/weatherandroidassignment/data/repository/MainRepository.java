package com.example.weatherandroidassignment.data.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/weatherandroidassignment/data/repository/MainRepository;", "Lcom/example/weatherandroidassignment/data/network/SafeApiRequest;", "api", "Lcom/example/weatherandroidassignment/data/network/MyApi;", "(Lcom/example/weatherandroidassignment/data/network/MyApi;)V", "quotes", "Landroidx/lifecycle/MutableLiveData;", "Lcom/example/weatherandroidassignment/data/network/response/WeatherResponse;", "getWeatherResult", "cityName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class MainRepository extends com.example.weatherandroidassignment.data.network.SafeApiRequest {
    private final androidx.lifecycle.MutableLiveData<com.example.weatherandroidassignment.data.network.response.WeatherResponse> quotes = null;
    private final com.example.weatherandroidassignment.data.network.MyApi api = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String API_KEY = "5ad7218f2e11df834b0eaf3a33a39d2a";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String METRIC = "metric";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String DAY_COUNT = "7";
    public static final com.example.weatherandroidassignment.data.repository.MainRepository.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getWeatherResult(@org.jetbrains.annotations.NotNull()
    java.lang.String cityName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.weatherandroidassignment.data.network.response.WeatherResponse> p1) {
        return null;
    }
    
    public MainRepository(@org.jetbrains.annotations.NotNull()
    com.example.weatherandroidassignment.data.network.MyApi api) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/weatherandroidassignment/data/repository/MainRepository$Companion;", "", "()V", "API_KEY", "", "DAY_COUNT", "METRIC", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}