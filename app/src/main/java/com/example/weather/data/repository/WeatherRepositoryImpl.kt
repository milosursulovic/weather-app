package com.example.weather.data.repository

import com.example.weather.data.mappers.toWeatherInfo
import com.example.weather.data.remote.WeatherApi
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.domain.util.Resource
import com.example.weather.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val api: WeatherApi
) : WeatherRepository {
    override suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo> =
        try {
            Resource.Success(api.getWeatherData(lat = lat, long = long).toWeatherInfo())
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred")
        }
}