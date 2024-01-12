package com.example.dailywheather.presentation.ui.daily_weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dailywheather.domain.models.Weather
import com.example.dailywheather.domain.repository.State
import com.example.dailywheather.domain.repository.WeatherRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DailyWeatherViewModel @Inject constructor(private val repositoryImpl: WeatherRepositoryImpl) : ViewModel(){

    var state by mutableStateOf(DailyWeatherState())
        private set

    init {
        viewModelScope.launch {
            state = DailyWeatherState(repositoryImpl.getWeather())
        }
    }

}

data class DailyWeatherState(
    val weather: State<Weather> = State.Loading()
)