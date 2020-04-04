package com.example.weatherandroidassignment.data.network.response


data class WeatherResponse(
    val message: Double,
    val cod: String,
    val cnt: Int,
    val city: CityData,
    val list: ArrayList<WeatherResult>
)

data class CityData(
    val id: Int,
    val name: String,
    val coord: CoordinateData,
    val country: String,
    val population: Long,
    val timezone: Long
)

data class WeatherResult(
    val dt: Long,
    val sunrise: Long,
    val sunset: Long,
    val temp: TemperatureData,
    val feels_like: MainData,
    val pressure: Long,
    val humidity: Long,
    val weather: ArrayList<WeatherData>,
    val speed: Double,
    val deg: Int,
    val clouds: Long
)
data class TemperatureData(
    val day: Double,
    val min: Double,
    val max: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)

data class CoordinateData(
    val lon: Double,
    val lat: Double
)

data class WeatherData(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class MainData(
    val day: Double,
    val night: Double,
    val eve: Double,
    val morn: Double
)