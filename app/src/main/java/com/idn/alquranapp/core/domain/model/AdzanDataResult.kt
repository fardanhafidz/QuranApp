package com.idn.alquranapp.core.domain.model

import com.idn.alquranapp.core.data.Resource

data class AdzanDataResult(
    val listLocation: List<String>,
    val dailyAdzan: Resource<DailyAdzan>,
    val listCalendar: List<String>
)
