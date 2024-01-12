package com.example.dailywheather.data.api.interceptors

import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber
import javax.inject.Inject

class LoginInterceptor @Inject constructor(): HttpLoggingInterceptor.Logger{
    override fun log(message: String) {
        Timber.tag("LoginInterceptor").i(message)
    }
}