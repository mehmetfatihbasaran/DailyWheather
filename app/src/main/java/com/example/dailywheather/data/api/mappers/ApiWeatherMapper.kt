package com.example.dailywheather.data.api.mappers

import com.example.dailywheather.data.api.models.ApiWeather
import com.example.dailywheather.domain.models.Weather
import javax.inject.Inject

class ApiWeatherMapper @Inject constructor(
    private val apiDailyMapper: ApiDailyMapper,
    private val apiCurrentWeatherMapper: CurrentWeatherMapper,
) : ApiMapper<Weather, ApiWeather> {
    override fun mapFromEntityToDomain(entity: ApiWeather): Weather {
        return Weather(
            currentWeather = apiCurrentWeatherMapper.mapFromEntityToDomain(entity.currentWeather),
            daily = apiDailyMapper.mapFromEntityToDomain(entity.daily)
        )
    }

}