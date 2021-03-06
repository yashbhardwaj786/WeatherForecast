package com.example.weatherandroidassignment.utils

import android.content.Context
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun getCurrentTime(): Long{
    val currentEpochTIme = System.currentTimeMillis()
    return currentEpochTIme / 1000
}

enum class DateFormat {
    USER_READABLE_WITH_TIME, TWELVE_FOUR_HOURS, USER_READABLE_WITH_DAY, USER_READABLE_WITH_DATE
}

fun getSimpleDateFormat(dateFormat: DateFormat): SimpleDateFormat? {
    var simpleDateFormat: SimpleDateFormat? = null
    when (dateFormat) {
        DateFormat.USER_READABLE_WITH_TIME -> {
            simpleDateFormat =
                SimpleDateFormat("dd MMMM YYYY, hh:mm a", Locale.ENGLISH)
        }
        DateFormat.TWELVE_FOUR_HOURS -> {
            simpleDateFormat =
                SimpleDateFormat(
                    "hh:mm a",
                    Locale.ENGLISH
                )
        }
        DateFormat.USER_READABLE_WITH_DAY -> {
            simpleDateFormat =
                SimpleDateFormat(
                    "EEEE",
                    Locale.ENGLISH
                )
        }
        DateFormat.USER_READABLE_WITH_DATE -> {
            simpleDateFormat =
                SimpleDateFormat(
                    "MMM dd",
                    Locale.ENGLISH
                )
        }
    }
    return simpleDateFormat
}
fun getTimeInHours(time: Long, desiredTimeFormat: DateFormat): String {
    val simpleDateFormat = getSimpleDateFormat(desiredTimeFormat)
    return simpleDateFormat?.format(Date(time)).toString()
}


