package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.weathermastercompose.data.model.ForecastDay
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun DailyForecastCard(forecastDay: ForecastDay) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            val date = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(forecastDay.date)
            val dayOfWeek = SimpleDateFormat("EEEE", Locale.getDefault()).format(date)

            Text(text = dayOfWeek, modifier = Modifier.weight(1f))
            AsyncImage(
                model = "https:${forecastDay.day.condition.icon}",
                contentDescription = forecastDay.day.condition.text,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
            Row {
                Text(text = "H:${forecastDay.day.maxtemp_c.toInt()}°")
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = "L:${forecastDay.day.mintemp_c.toInt()}°")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyForecastCardPreview() {
    DailyForecastCard(
        forecastDay = ForecastDay(
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
        )
    )
}
