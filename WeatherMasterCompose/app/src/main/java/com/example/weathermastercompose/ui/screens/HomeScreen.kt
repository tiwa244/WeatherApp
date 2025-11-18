package com.example.weathermastercompose.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Box
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weathermastercompose.ui.components.ConditionGrid
import com.example.weathermastercompose.ui.components.DailyForecastList
import com.example.weathermastercompose.ui.components.HourlyForecastRow
import com.example.weathermastercompose.ui.components.MainTemperatureDisplay
import com.example.weathermastercompose.ui.components.SearchBar
import com.example.weathermastercompose.ui.viewmodel.WeatherViewModel

@Composable
fun HomeScreen(viewModel: WeatherViewModel = viewModel()) {
    val weather by viewModel.weather.collectAsState()
    val error by viewModel.error.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchWeather("London")
    }

    Column(modifier = Modifier.fillMaxSize()) {
        SearchBar { location ->
            viewModel.fetchWeather(location)
        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            error?.let {
                Text(text = it, color = Color.Red)
            } ?: weather?.let {
                Column {
                    MainTemperatureDisplay(it.current, it.forecast.forecastday[0])
                    HourlyForecastRow(it.forecast.forecastday[0].hour)
                    DailyForecastList(it.forecast.forecastday)
                    ConditionGrid(it.current)
                }
            } ?: CircularProgressIndicator()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
