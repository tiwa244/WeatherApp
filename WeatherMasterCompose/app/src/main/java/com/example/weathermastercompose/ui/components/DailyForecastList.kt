package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermastercompose.data.model.ForecastDay

@Composable
fun DailyForecastList(forecastDays: List<ForecastDay>) {
    LazyColumn {
        items(forecastDays) { forecastDay ->
            DailyForecastCard(forecastDay)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyForecastListPreview() {
    DailyForecastList(
        forecastDays = listOf(
            ForecastDay(
                date = "2023-07-20",
                day = com.example.weathermastercompose.data.model.Day(
                    maxtemp_c = 26.0,
                    mintemp_c = 18.0,
                    condition = com.example.weathermastercompose.data.model.Condition(
                        text = "Partly cloudy",
                        icon = "//cdn.weatherapi.com/weather/64x64/day/116.png"
                    )
                ),
                hour = emptyList()
            ),
            ForecastDay(
                date = "2023-07-21",
                day = com.example.weathermastercompose.data.model.Day(
                    maxtemp_c = 27.0,
                    mintemp_c = 19.0,
                    condition = com.example.weathermastercompose.data.model.Condition(
                        text = "Sunny",
                        icon = "//cdn.weatherapi.com/weather/64x64/day/113.png"
                    )
                ),
                hour = emptyList()
            )
        )
    )
}
