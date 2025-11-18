package com.example.weathermastercompose.data.model

data class Weather(
    val current: Current,
    val forecast: Forecast
)

data class Current(
    val temp_c: Double,
    val feelslike_c: Double,
    val condition: Condition,
    val wind_kph: Double,
    val humidity: Int,
    val uv: Double,
    val pressure_mb: Double
)

data class Forecast(
    val forecastday: List<ForecastDay>
)

data class ForecastDay(
    val date: String,
    val day: Day,
    val hour: List<Hour>
)

data class Day(
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val condition: Condition
)

data class Hour(
    val time: String,
    val temp_c: Double,
    val condition: Condition
)

data class Condition(
    val text: String,
    val icon: String
)
