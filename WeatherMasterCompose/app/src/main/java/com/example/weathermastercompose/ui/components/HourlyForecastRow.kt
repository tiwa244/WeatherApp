package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermastercompose.data.model.Condition
import com.example.weathermastercompose.data.model.Hour

@Composable
fun HourlyForecastRow(hours: List<Hour>) {
    LazyRow {
        items(hours) { hour ->
            HourlyForecastCard(hour)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HourlyForecastRowPreview() {
    HourlyForecastRow(
        hours = listOf(
            Hour(
                time = "2023-07-20 10:00", temp_c = 23.0, condition = Condition(
                    text = "Sunny",
                    icon = "//cdn.weatherapi.com/weather/64x64/day/113.png"
                )
            ),
            Hour(
                time = "2023-07-20 11:00", temp_c = 24.0, condition = Condition(
                    text = "Sunny",
                    icon = "//cdn.weatherapi.com/weather/64x64/day/113.png"
                )
            ),
            Hour(
                time = "2023-07-20 12:00", temp_c = 25.0, condition = Condition(
                    text = "Sunny",
                    icon = "//cdn.weatherapi.com/weather/64x64/day/113.png"
                )
            )
        )
    )
}
