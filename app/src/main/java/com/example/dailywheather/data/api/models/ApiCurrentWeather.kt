package com.example.dailywheather.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiCurrentWeather(
    @Json(name = "is_day")
    val isDay: Int,
    @Json(name = "temperature")
    val temperature: Double,
    @Json(name = "time")
    val time: Long,
    @Json(name = "weathercode")
    val weathercode: Int,
    @Json(name = "winddirection")
    val winddirection: Double,
    @Json(name = "windspeed")
    val windspeed: Double
)