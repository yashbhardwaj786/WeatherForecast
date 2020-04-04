package com.example.weatherandroidassignment.ui.modelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weatherandroidassignment.data.repository.MainRepository
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel

class MainViewModelFactory(
    private val repository: MainRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}