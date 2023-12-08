package com.idn.alquranapp.core.domain.repository

import com.idn.alquranapp.core.data.Resource
import com.idn.alquranapp.core.domain.model.QuranEdition
import com.idn.alquranapp.core.domain.model.Surah
import kotlinx.coroutines.flow.Flow

interface IQuranRepository {

    fun getListSurah() : Flow<Resource<List<Surah>>>

    fun getDetailSurahWithQuranEditions(number: Int) : Flow<Resource<List<QuranEdition>>>
}