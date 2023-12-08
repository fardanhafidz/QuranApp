package com.idn.alquranapp.core.domain.repository

import androidx.lifecycle.LiveData
import com.idn.alquranapp.core.data.Resource
import com.idn.alquranapp.core.domain.model.City
import com.idn.alquranapp.core.domain.model.DailyAdzan
import kotlinx.coroutines.flow.Flow

interface IAdzanRepository {

    fun getLastKnownLocation(): LiveData<List<String>>
    fun searchCity(city: String): Flow<Resource<List<City>>>
    fun getDailyAdzanTime(
        id: String,
        year: String,
        month: String,
        date: String
    ): Flow<Resource<DailyAdzan>>
}