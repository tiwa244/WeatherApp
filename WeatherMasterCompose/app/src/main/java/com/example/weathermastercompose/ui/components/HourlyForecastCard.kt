package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weathermastercompose.data.model.Hour

@Composable
fun HourlyForecastCard(hour: Hour) {
    Card(modifier = Modifier.padding(8.dp)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = hour.time.split(" ")[1])
            AsyncImage(
                model = "https:${hour.condition.icon}",
                contentDescription = hour.condition.text
            )
            Text(text = "${hour.temp_c.toInt()}°")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HourlyForecastCardPreview() {
    HourlyForecastCard(
        hour = Hour(
            time = "2023-07-20 10:00",
            temp_c = 23.0,
            condition = com.example.weathermastercompose.data.model.Condition(
                text = "Sunny",
                icon = "//cdn.weatherapi.com/weather/64x64/day/113.png"
            )
        )
    )
}
