package com.example.weatherandroidassignment.data.network.response


data class WeatherResponse(
    val message: String,
    val cod: Int,
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
    val timezone: Long,
    val sunrise: Long,
    val sunset: Long
)

data class WeatherResult(
    val dt: Long,
    val main: MainData,
    val weather: ArrayList<WeatherData>,
    val clouds: CloudsData,
    val wind: WindData,
    val sys: SunsetData,
    val dt_txt: String
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
    val temp: Double,
    val feels_like: Double,
    val temp_max: Double,
    val temp_min: Double,
    val pressure: Int,
    val humidity: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val temp_kf: Float
)

data class WindData(
    val speed: Double,
    val deg: Int
)

data class CloudsData(
    val all: Int
)

data class SunsetData(
    val pod: String
)
