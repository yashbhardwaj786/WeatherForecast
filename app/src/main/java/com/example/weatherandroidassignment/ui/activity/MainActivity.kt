package com.example.weatherandroidassignment.ui.activity

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherandroidassignment.R
import com.example.weatherandroidassignment.databinding.ActivityMainBinding
import com.example.weatherandroidassignment.ui.activity.SplashActivity.Companion.CITY_NAME
import com.example.weatherandroidassignment.ui.adapter.WeatherListAdapter
import com.example.weatherandroidassignment.ui.modelfactory.MainViewModelFactory
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel
import com.example.weatherandroidassignment.utils.*
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import java.util.*


class MainActivity : BaseActivity(), KodeinAware {

    override val kodein by kodein()
    private val factory: MainViewModelFactory by instance()
    private lateinit var mainViewModel: MainViewModel
    private var isSameCity = false
    private var cityName = ""
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel =
            ViewModelProvider(this, factory).get(MainViewModel::class.java)

        binding.viewModel = mainViewModel

        setToolBar(false, "Weather Forecast")

        intent.getStringExtra(CITY_NAME)?.let {
            cityName = it
            mainViewModel.isSameLocation.set(isSameCity)
        }

        makeAPICall()

        mainViewModel.onFailure.observe(this, Observer {
            Coroutines.main {
                binding.errorModel = mainViewModel.errorModel
            }
        })

        mainViewModel.onStart.observe(this, Observer {
            mainViewModel.shimmerVisible.set(true)
            mainViewModel.onError.set(false)
        })

        mainViewModel.onSuccess.observe(this, Observer {
            mainViewModel.onError.set(false)
            val weatherResult = it.list[0]
            binding.data = weatherResult
            binding.cityData = it.city
            val c: Date = Calendar.getInstance().time

            val df = getSimpleDateFormat(DateFormat.USER_READABLE_WITH_TIME)
            df?.let { sdf ->
                binding.date = sdf.format(c)
            }

            weatherResult.sunrise.let { sunriseTime ->
                val sunRISETTime = getTimeInHours(sunriseTime * 1000, DateFormat.TWELVE_FOUR_HOURS)
                binding.sunriseTime = sunRISETTime
            }

            weatherResult.sunset.let { sunsetTime ->
                val sunsetTTime = getTimeInHours(sunsetTime * 1000, DateFormat.TWELVE_FOUR_HOURS)
                binding.sunsetTime = sunsetTTime
            }

            weatherResult.weather.let { weatherData ->
                if (weatherData.isNotEmpty()) {
                    weatherData[0].description.let { status ->
                        binding.status = status

                    }
                }
            }

            weatherResult.temp.let { temp ->

                val cal = Calendar.getInstance()
                val temperature = when (cal[Calendar.HOUR_OF_DAY]) {
                    in 4..9 -> {
                        String.format("%.2f", temp.morn)
                    }
                    in 10..14 -> {
                        String.format("%.2f", temp.day)
                    }
                    in 15..19 -> {
                        String.format("%.2f", temp.eve)
                    }
                    else -> {
                        String.format("%.2f", temp.night)
                    }
                }
                binding.averageTemp = temperature
            }

            if (it.list.size > 0){
                weeklyWeatherRecyclerView.visibility = View.VISIBLE
                weeklyWeatherRecyclerView.apply {
                    addItemDecoration(GridItemDecoration(20, 2))
                    layoutManager = GridLayoutManager(context, 4)
//                    layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    adapter = WeatherListAdapter(context, it.list, mainViewModel)
                }
            } else {
                weeklyWeatherRecyclerView.visibility = View.GONE
            }
        })
    }

    private fun makeAPICall() {
        mainViewModel.apiCallToGetWeatherData(cityName)
    }


}