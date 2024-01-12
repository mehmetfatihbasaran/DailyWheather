package com.example.dailywheather.domain.repository

import com.example.dailywheather.domain.models.Weather

interface WeatherRepository {

    suspend fun getWeather(): State<Weather>

}