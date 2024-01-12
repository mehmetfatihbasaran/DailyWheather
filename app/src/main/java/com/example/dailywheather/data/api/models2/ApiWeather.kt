package com.example.dailywheather.data.api.models2


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiWeather(
    @SerialName("current_weather")
    val currentWeather: CurrentWeather,
    @SerialName("daily")
    val daily: Daily,
    @SerialName("daily_units")
    val dailyUnits: DailyUnits,
    @SerialName("elevation")
    val elevation: Double,
    @SerialName("generationtime_ms")
    val generationtimeMs: Double,
    @SerialName("latitude")
    val latitude: Double,
    @SerialName("longitude")
    val longitude: Double,
    @SerialName("timezone")
    val timezone: String,
    @SerialName("timezone_abbreviation")
    val timezoneAbbreviation: String,
    @SerialName("utc_offset_seconds")
    val utcOffsetSeconds: Int
) {
    @Serializable
    data class CurrentWeather(
        @SerialName("is_day")
        val isDay: Int,
        @SerialName("temperature")
        val temperature: Double,
        @SerialName("time")
        val time: Int,
        @SerialName("weathercode")
        val weathercode: Int,
        @SerialName("winddirection")
        val winddirection: Double,
        @SerialName("windspeed")
        val windspeed: Double
    )

    @Serializable
    data class Daily(
        @SerialName("temperature_2m_max")
        val temperature2mMax: List<Double>,
        @SerialName("temperature_2m_min")
        val temperature2mMin: List<Double>,
        @SerialName("time")
        val time: List<Int>,
        @SerialName("weathercode")
        val weathercode: List<Int>,
        @SerialName("winddirection_10m_dominant")
        val winddirection10mDominant: List<Int>,
        @SerialName("windspeed_10m_max")
        val windspeed10mMax: List<Double>
    )

    @Serializable
    data class DailyUnits(
        @SerialName("temperature_2m_max")
        val temperature2mMax: String,
        @SerialName("temperature_2m_min")
        val temperature2mMin: String,
        @SerialName("time")
        val time: String,
        @SerialName("weathercode")
        val weathercode: String,
        @SerialName("winddirection_10m_dominant")
        val winddirection10mDominant: String,
        @SerialName("windspeed_10m_max")
        val windspeed10mMax: String
    )
}