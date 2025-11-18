package com.example.weathermastercompose.data.remote

import com.example.weathermastercompose.BuildConfig
import com.example.weathermastercompose.data.model.Weather
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApiService {
    @GET("forecast.json")
    suspend fun getWeather(
        @Query("key") apiKey: String = BuildConfig.API_KEY,
        @Query("q") location: String,
        @Query("days") days: Int = 7
    ): Weather
}
