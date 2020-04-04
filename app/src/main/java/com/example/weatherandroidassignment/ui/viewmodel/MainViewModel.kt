package com.example.weatherandroidassignment.ui.viewmodel

import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.ViewModel
import com.example.weatherandroidassignment.data.network.response.WeatherResponse
import com.example.weatherandroidassignment.data.repository.MainRepository
import com.example.weatherandroidassignment.utils.ApiException
import com.example.weatherandroidassignment.utils.NoInternetException
import com.example.weatherandroidassignment.utils.WifiNotConnectedException
import kotlinx.coroutines.launch


class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {

    // variable Declaration
    val onStart = MutableLiveData<Any>()
    val onSuccess = MutableLiveData<WeatherResponse>()
    val onFailure = MutableLiveData<String>()
    val errorModel: ErrorModel by lazy { ErrorModel() }
    val onError = ObservableBoolean(false)
    var shimmerVisible = ObservableField<Boolean>(true)
    val isSameLocation = ObservableBoolean(true)

    // API call
    fun apiCallToGetWeatherData(cityName: String) {
        onStart.postValue("")
        viewModelScope.launch {
            try {
                val response = repository.getWeatherResult(cityName)
                response.let {
                    shimmerVisible.set(false)
                    val result = it
                    onSuccess.postValue(result)
                    return@launch
                }
            } catch (ex: ApiException) {
                shimmerVisible.set(false)
                onError.set(true)
                showErrorModel(
                    ERROR_TITLE,
                    ERROR_DESCRIPTION,
                    cityName
                )
                onFailure.postValue("${ex.message}")
                ex.printStackTrace()
            } catch (ex: NoInternetException) {
                shimmerVisible.set(false)
                onError.set(true)
                showErrorModel(
                    NO_INTERNET,
                    ex.localizedMessage!!,
                    cityName
                )
                onFailure.postValue("${ex.message}")
                ex.printStackTrace()
            } catch (ex: WifiNotConnectedException){
                shimmerVisible.set(false)
                onError.set(true)
                showErrorModel(
                    WIFI_NOT_CONNECTED,
                    ex.localizedMessage!!,
                    cityName
                )
                onFailure.postValue("${ex.message}")
                ex.printStackTrace()
            }
        }
    }

    // Show Error Model
    private fun showErrorModel(
        title: String,
        subTitle: String,
        cityName: String
    ) {
        errorModel.apply {
            errorTitle = title
            errorSubTitle = subTitle
            buttonText = RETRY
            errorActionListener = object : ErrorActionListener {
                override fun onErrorActionClicked() {
                    apiCallToGetWeatherData(cityName)
                }
            }
        }
    }


    companion object {
        const val ERROR_TITLE = "Something went wrong.."
        const val WIFI_NOT_CONNECTED = "Wifi not connected"
        const val NO_INTERNET = "No Internet"
        const val ERROR_DESCRIPTION = "An alien is probably blocking your signal."
        const val RETRY = "RETRY"
    }
}