package com.example.weathermastercompose.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.weathermastercompose.data.model.Current

@Composable
fun ConditionGrid(current: Current) {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ConditionCard(title = "Wind", value = "${current.wind_kph} km/h")
            ConditionCard(title = "Humidity", value = "${current.humidity}%")
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            ConditionCard(title = "UV Index", value = "${current.uv}")
            ConditionCard(title = "Pressure", value = "${current.pressure_mb} hPa")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ConditionGridPreview() {
    ConditionGrid(
        current = Current(
            temp_c = 23.0,
            feelslike_c = 25.0,
            condition = com.example.weathermastercompose.data.model.Condition("", ""),
            wind_kph = 10.0,
            humidity = 65,
            uv = 5.0,
            pressure_mb = 1012.0
        )
    )
}
