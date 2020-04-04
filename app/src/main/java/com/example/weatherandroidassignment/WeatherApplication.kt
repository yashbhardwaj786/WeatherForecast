package com.example.weatherandroidassignment

import android.app.Application
import com.example.weatherandroidassignment.data.network.NetworkConnectionInterceptor
import com.example.weatherandroidassignment.data.network.RestAPIClient
import com.example.weatherandroidassignment.data.repository.MainRepository
import com.example.weatherandroidassignment.ui.modelfactory.MainViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class WeatherApplication : Application(), KodeinAware{

    override val kodein = Kodein.lazy {
        import(androidXModule(this@WeatherApplication))
        bind() from singleton { RestAPIClient(instance()) }
        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MainRepository(instance()) }
        bind() from provider { MainViewModelFactory(instance()) }
    }
}
