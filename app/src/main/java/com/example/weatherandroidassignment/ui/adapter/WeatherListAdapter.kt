package com.example.weatherandroidassignment.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherandroidassignment.R
import com.example.weatherandroidassignment.data.network.response.WeatherResult
import com.example.weatherandroidassignment.databinding.LayoutWeatherItemBinding
import com.example.weatherandroidassignment.ui.viewmodel.MainViewModel
import com.example.weatherandroidassignment.utils.DateFormat
import com.example.weatherandroidassignment.utils.getSimpleDateFormat
import com.example.weatherandroidassignment.utils.getTimeInHours
import java.util.*
import kotlin.collections.ArrayList

class WeatherListAdapter(
    private val context: Context,
    private val WeatherList: ArrayList<WeatherResult>,
    private val model: MainViewModel
) : RecyclerView.Adapter<WeatherListAdapter.WeatherAdapterViewHolder>() {

    private lateinit var layoutInflater: LayoutInflater

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherAdapterViewHolder {

        layoutInflater = LayoutInflater.from(parent.context)
        val binding: LayoutWeatherItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.layout_weather_item, parent, false)
        return WeatherAdapterViewHolder(binding.root, binding)
    }

    override fun getItemCount() = WeatherList.size

    override fun onBindViewHolder(holder: WeatherAdapterViewHolder, position: Int) {
        val weatherResult: WeatherResult = WeatherList[position]
        holder.binding.data = weatherResult
        holder.binding.viewModel = model

        val currentDate: Date = Calendar.getInstance().time
        var currentDay = ""
        val df = getSimpleDateFormat(DateFormat.USER_READABLE_WITH_DAY)
        df?.let { sdf ->
            currentDay  = sdf.format(currentDate)
        }
        val day = getTimeInHours(weatherResult.dt * 1000, DateFormat.USER_READABLE_WITH_DAY)
        if (day == currentDay){
            holder.binding.currentDay = "Today"
        } else {
            holder.binding.currentDay = day
        }

        val date = getTimeInHours(weatherResult.dt * 1000, DateFormat.USER_READABLE_WITH_DATE)
        holder.binding.currentDate = date
    }

    class WeatherAdapterViewHolder(itemView: View, var binding: LayoutWeatherItemBinding) :
        RecyclerView.ViewHolder(itemView)
}