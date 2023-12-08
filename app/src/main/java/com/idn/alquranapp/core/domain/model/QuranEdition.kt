package com.idn.alquranapp.core.domain.model

data class QuranEdition (
    val number: Int? = null,
    val name: String? = null,
    val englishName: String? = null,
    val englishNameTranslation: String? = null,
    val revelationType: String? = null,
    val numberOfAyahs: Int? = null,
    val listAyahs: List<Ayah>,
)