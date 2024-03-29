package com.example.dailywheather.domain.models

data class CurrentWeather(
    val temperature: Double,
    val time: String,
    val weatherStatus: String,
    val windDirection: String,
    val windSpeed: Double,
)
