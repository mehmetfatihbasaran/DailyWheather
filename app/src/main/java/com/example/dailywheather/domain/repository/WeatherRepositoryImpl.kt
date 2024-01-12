package com.example.dailywheather.domain.repository

import com.example.dailywheather.data.api.WeatherApi
import com.example.dailywheather.data.api.mappers.ApiWeatherMapper
import com.example.dailywheather.domain.models.Weather
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi,
    private val apiWeatherMapper: ApiWeatherMapper
) : WeatherRepository{
    override suspend fun getWeather(): State<Weather> {
        return try {
            val response = weatherApi.getWeather()
            val weather = apiWeatherMapper.mapFromEntityToDomain(response)
            State.Success(weather)
        } catch (e: Exception) {
            State.Error(e.toString())
        }
    }
}