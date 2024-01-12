package com.example.dailywheather.presentation.ui.daily_weather

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.dailywheather.domain.models.CurrentWeather
import com.example.dailywheather.domain.models.Daily
import com.example.dailywheather.domain.repository.State
import timber.log.Timber

@Composable
fun DailyWeatherHomeScreen() {

    val viewModel : DailyWeatherViewModel = viewModel()
    val state = viewModel.state.weather
    val dailyWeatherInfo = state.data?.daily?.weatherInfo ?: emptyList()
    val gradientColors = listOf(
        Color(0xFFE7F7FF),
        Color(0xFF0D9DE3),
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.verticalGradient(gradientColors))
    ) {
        when (state) {
            is State.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(Alignment.Center)
                )
            }
            is State.Success -> {
                state.data?.currentWeather?.let {
                    CurrentWeatherCard(currentWeather = it)
                }

                LazyVerticalGrid( GridCells.Fixed(2)){

                    items(dailyWeatherInfo){ weatherInfo ->
                        DailyWeatherCard(dailyWeatherInfo = weatherInfo)


                    }

                }
            }
            is State.Error -> {
                Timber.tag("Error").e(state.message.toString())
            }
        }
    }

}


@Composable
fun CurrentWeatherCard(currentWeather: CurrentWeather) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface.copy(.1f)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Text(text = currentWeather.time)
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(4.dp)
            ) {
                Column {
                    Text(text = "${currentWeather.temperature} \u00B0C")
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = currentWeather.weatherStatus)
                }
                Spacer(modifier = Modifier.size(8.dp))
                Column {
                    Text(text = currentWeather.windDirection)
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(text = currentWeather.windSpeed.toString() + "kph")
                }
                Spacer(modifier = Modifier.size(8.dp))
            }


        }


    }


}


@Composable
fun DailyWeatherCard(dailyWeatherInfo: Daily.WeatherInfo) {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth(),
        backgroundColor = MaterialTheme.colors.surface.copy(.1f)
    ) {
        Column(
            modifier = Modifier.padding(4.dp)
        ) {
            Text(
                text = dailyWeatherInfo.time,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
            Text(text = "${dailyWeatherInfo.temperatureMax} \u00B0C /" +
                    " ${dailyWeatherInfo.temperatureMin} °C")
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = dailyWeatherInfo.weatherStatus)
            Text(text = dailyWeatherInfo.windDirection)
            Spacer(modifier = Modifier.size(4.dp))
            Text(text = dailyWeatherInfo.windSpeed.toString() + "kph")
        }


    }


}



