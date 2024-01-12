package com.example.dailywheather.data.api.mappers

import com.example.dailywheather.data.api.models.ApiDaily
import com.example.dailywheather.domain.models.Daily
import com.example.dailywheather.util.Util
import javax.inject.Inject

class ApiDailyMapper @Inject constructor() : ApiMapper<Daily, ApiDaily>{
    override fun mapFromEntityToDomain(entity: ApiDaily): Daily {
        return Daily(
            temperatureMax = entity.temperature2mMax,
            temperatureMin = entity.temperature2mMin,
            time = parseTime(entity.time),
            weatherStatus = parseWeatherStatus(entity.weathercode),
            windDirection = parseWindDirection(entity.winddirection10mDominant),
            windSpeed = entity.windspeed10mMax,
        )
    }

    private fun parseTime(time: List<Long>): List<String> {
        return time.map {
            Util.formatDate("E", it)
        }
    }

    private fun parseWeatherStatus(code: List<Int>): List<String>{
        return code.map {
            Util.getWeatherInfo(it)
        }
    }

    private fun parseWindDirection(windDirection: List<Double>): List<String>{
        return windDirection.map {
            Util.getWindDirection(it)
        }
    }

}