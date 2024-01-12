package com.example.dailywheather.data.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiDaily(
    @Json(name = "temperature_2m_max")
    val temperature2mMax: List<Double>,
    @Json(name = "temperature_2m_min")
    val temperature2mMin: List<Double>,
    @Json(name = "time")
    val time: List<Long>,
    @Json(name = "weathercode")
    val weathercode: List<Int>,
    @Json(name = "winddirection_10m_dominant")
    val winddirection10mDominant: List<Double>,
    @Json(name = "windspeed_10m_max")
    val windspeed10mMax: List<Double>
)