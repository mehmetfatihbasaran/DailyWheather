package com.example.dailywheather.data.api.mappers

import com.example.dailywheather.data.api.models.ApiCurrentWeather
import com.example.dailywheather.domain.models.CurrentWeather
import com.example.dailywheather.util.Util
import javax.inject.Inject

class CurrentWeatherMapper @Inject constructor() : ApiMapper<CurrentWeather, ApiCurrentWeather>{
    override fun mapFromEntityToDomain(entity: ApiCurrentWeather): CurrentWeather {
        return CurrentWeather(
            temperature = entity.temperature,
            time = parseTime(entity.time),
            weatherStatus = parseWeatherStatus(entity.weathercode),
            windDirection = parseWindDirection(entity.winddirection),
            windSpeed = entity.windspeed
        )
    }

    private fun parseTime(time: Long): String {
        return Util.formatDate("E", time)
    }

    private fun parseWeatherStatus(code: Int): String{
        return Util.getWeatherInfo(code)
    }

    private fun parseWindDirection(windDirection: Double): String{
        return Util.getWindDirection(windDirection)
    }
}