package com.example.weathermastercompose.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weathermastercompose.data.model.Weather
import com.example.weathermastercompose.data.remote.RetrofitClient
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {

    private val _weather = MutableStateFlow<Weather?>(null)
    val weather: StateFlow<Weather?> = _weather

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    fun fetchWeather(location: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.getWeather(location = location)
                _weather.value = response
                _error.value = null
            } catch (e: Exception) {
                _error.value = "Could not fetch weather data. Please try again."
            }
        }
    }
}
