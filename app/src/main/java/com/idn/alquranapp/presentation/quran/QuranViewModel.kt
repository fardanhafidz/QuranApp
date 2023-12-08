package com.idn.alquranapp.presentation.quran

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.idn.alquranapp.core.data.QuranRepository

class QuranViewModel(private val quranRepository: QuranRepository) : ViewModel() {

    fun getListSurah() = quranRepository.getListSurah().asLiveData()

    fun getDetailSurahWithQuranEdition(number: Int) = quranRepository.getDetailSurahWithQuranEditions(number).asLiveData()
}