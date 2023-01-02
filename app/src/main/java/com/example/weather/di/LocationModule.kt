package com.example.weather.di

import android.app.Application
import com.example.weather.data.location.DefaultLocationTracker
import com.example.weather.domain.location.LocationTracker
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {
    @Provides
    @Singleton
    fun providesFusedLocationProviderClient(app: Application): FusedLocationProviderClient =
        LocationServices.getFusedLocationProviderClient(app)

    @Provides
    @Singleton
    fun providesLocationTracker(defaultLocationTracker: DefaultLocationTracker): LocationTracker =
        defaultLocationTracker
}