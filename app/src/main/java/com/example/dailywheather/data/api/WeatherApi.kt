package com.example.dailywheather.data.api

import com.example.dailywheather.data.api.models.ApiWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(ApiConstants.END_POINT)
    suspend fun getWeather(
        @Query(ApiParameters.LATITUDE) latitude: Float = -6.80f,
        @Query(ApiParameters.LONGITUDE) longitude: Float = 39.62f,
        @Query(ApiParameters.DAILY) daily: Array<String> = arrayOf(
            "weathercode",
            "temperature_2m_max",
            "temperature_2m_min",
            "windspeed_10m_max",
            "winddirection_10m_dominant",
        ),
        @Query(ApiParameters.CURRENT_WEATHER) currentWeather: Boolean = true,
        @Query(ApiParameters.TIME_FORMAT) timeFormat: String = "unixtime",
        @Query(ApiParameters.TIME_ZONE) timeZone: String = "Europe/Amsterdam",
    ): ApiWeather

}