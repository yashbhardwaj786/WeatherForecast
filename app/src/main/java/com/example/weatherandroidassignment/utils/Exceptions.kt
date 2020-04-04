package com.example.weatherandroidassignment.utils

import java.io.IOException

class ApiException(message: String) : IOException(message)

class NoInternetException(message: String) : IOException(message)

class WifiNotConnectedException(message: String) : IOException(message)