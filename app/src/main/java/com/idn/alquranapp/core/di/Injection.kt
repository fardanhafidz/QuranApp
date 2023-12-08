package com.idn.alquranapp.core.di

import android.content.Context
import com.idn.alquranapp.core.data.AdzanRepository
import com.idn.alquranapp.core.data.QuranRepository
import com.idn.alquranapp.core.data.network.RemoteDataSource
import com.idn.alquranapp.core.data.local.CalendarPreferences
import com.idn.alquranapp.core.data.local.LocationPreferences
import com.idn.alquranapp.core.data.network.ApiConfig

object Injection {
    private val quranApiService = ApiConfig.getQuranService
    private val adzanApiService = ApiConfig.getAdzanTimeService
    private val remoteDataSource = RemoteDataSource(quranApiService, adzanApiService)
    fun provideQuranRepository(): QuranRepository {
        return QuranRepository(remoteDataSource)
    }

    fun provideAdzanRepository(context: Context): AdzanRepository {
        val locationPreferences = LocationPreferences(context)
        val calendarPrefrences = CalendarPreferences()
        return AdzanRepository(remoteDataSource, locationPreferences, calendarPrefrences)
    }
}