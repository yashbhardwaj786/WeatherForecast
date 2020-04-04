package com.example.weatherandroidassignment.data.network

import com.example.weatherandroidassignment.data.network.response.WeatherResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface RestAPIClient {

    @GET("forecast/daily")
    suspend fun getWeatherDetails(@Query("q") cityName: String, @Query("units") units: String,
                                  @Query("appid") api_key: String, @Query("cnt") count: String,
                                  @Query("mode") mode: String): Response<WeatherResponse>

    companion object {
        operator fun invoke(
            networkConnectionInterceptor: NetworkConnectionInterceptor
        ): RestAPIClient {

            val gson = GsonBuilder()
                .setLenient()
                .create()

            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(networkConnectionInterceptor)
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(RestAPIClient::class.java)
        }
    }
}