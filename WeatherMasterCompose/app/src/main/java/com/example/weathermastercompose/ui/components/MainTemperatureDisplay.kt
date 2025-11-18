package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.weathermastercompose.data.model.Condition
import com.example.weathermastercompose.data.model.Current
import com.example.weathermastercompose.data.model.Day

@Composable
fun MainTemperatureDisplay(current: Current, day: Day) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "${current.temp_c.toInt()}°",
            fontSize = 100.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Feels like ${current.feelslike_c.toInt()}°",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Text(
                text = "H:${day.maxtemp_c.toInt()}°",
                fontSize = 20.sp,
                modifier = Modifier.padding(end = 8.dp)
            )
            Text(
                text = "L:${day.mintemp_c.toInt()}°",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainTemperatureDisplayPreview() {
    MainTemperatureDisplay(
        current = Current(
            temp_c = 23.0,
            feelslike_c = 25.0,
            condition = Condition("", ""),
            wind_kph = 10.0,
            humidity = 65,
            uv = 5.0,
            pressure_mb = 1012.0
        ),
        day = Day(
            maxtemp_c = 26.0,
            mintemp_c = 18.0,
            condition = Condition("", "")
        )
    )
}
