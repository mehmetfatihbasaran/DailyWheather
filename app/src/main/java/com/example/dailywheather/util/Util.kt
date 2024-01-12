package com.example.dailywheather.util

import java.text.SimpleDateFormat
import java.util.Locale

object Util {
    private val DIRECTIONS = listOf(
        "North",
        "North East",
        "East",
        "South East",
        "South",
        "South West",
        "West",
        "North West"
    )

    fun formatDate(pattern: String, time: Long): String {
        val sdf = SimpleDateFormat(pattern, Locale.getDefault())

        return sdf.format(time*1000)
    }

    fun getWindDirection(windDirection: Double): String {
        return DIRECTIONS[(windDirection % 360 / 45 % 8).toInt()]
    }

    fun getWeatherInfo(code: Int): String {
        return when (code) {
            0 -> "Clear sky"
            in 1..3 -> "Mainly clear, partly cloudy, and overcast"
            in listOf(45, 48) -> "Fog and depositing rime fog"
            in listOf(51, 53, 55) -> "Drizzle: Light, moderate, and dense intensity"
            in listOf(56, 57) -> "Freezing Drizzle: Light and dense intensity"
            in listOf(61, 63, 65) -> "Rain: Slight, moderate and heavy intensity"
            in listOf(66, 67) -> "Freezing Rain: Light and heavy intensity"
            in listOf(71, 73, 75) -> "Snow fall: Slight, moderate, and heavy intensity"
            77 -> "Snow grains"
            in listOf(80, 81, 82) -> "Rain showers: Slight, moderate, and violent"
            in listOf(85, 86) -> "Snow showers slight and heavy"
            in listOf(95) -> "Thunderstorm: Slight or moderate"
            in listOf(96, 99) -> "Thunderstorm with slight and heavy hail"
            else -> "Unknown weather code"
        }
    }

}