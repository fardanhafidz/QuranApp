package com.idn.alquranapp.presentation.adzan

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.idn.alquranapp.core.data.AdzanRepository
import com.idn.alquranapp.core.data.Resource
import com.idn.alquranapp.core.domain.model.AdzanDataResult

class AdzanViewModel(private val adzanRepository: AdzanRepository) : ViewModel() {

    fun getDailyAdzanTime(): LiveData<Resource<AdzanDataResult>> = adzanRepository.getResultDailyAdzanTime()
}