package com.example.weatherandroidassignment.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.weatherandroidassignment.data.network.RestAPIClient
import com.example.weatherandroidassignment.data.network.SafeApiRequest
import com.example.weatherandroidassignment.data.network.response.WeatherResponse

class MainRepository(
    private val api: RestAPIClient
) : SafeApiRequest() {

    private val quotes = MutableLiveData<WeatherResponse>()

    suspend fun getWeatherResult(cityName: String): WeatherResponse {
        val response = apiRequest { api.getWeatherDetails(cityName, METRIC, API_KEY, DAY_COUNT) }
        quotes.postValue(response)
        return response
    }

    companion object {
        const val API_KEY = "5ad7218f2e11df834b0eaf3a33a39d2a"
        const val METRIC = "metric"
        const val DAY_COUNT = "7"
    }
}