package com.idn.alquranapp.core.data

import com.idn.alquranapp.core.data.network.NetworkBoundResource
import com.idn.alquranapp.core.data.network.NetworkResponse
import com.idn.alquranapp.core.data.network.RemoteDataSource
import com.idn.alquranapp.core.domain.model.QuranEdition
import com.idn.alquranapp.core.domain.model.Surah
import com.idn.alquranapp.core.domain.repository.IQuranRepository
import com.idn.alquranapp.core.data.network.quran.QuranEditionItem
import com.idn.alquranapp.core.data.network.quran.SurahItem
import com.idn.alquranapp.utils.DataMapper
import kotlinx.coroutines.flow.Flow

class QuranRepository(private val remoteDataSource: RemoteDataSource) : IQuranRepository {
    override fun getListSurah(): Flow<Resource<List<Surah>>> {
        return object : NetworkBoundResource<List<Surah>, List<SurahItem>>() {
            override fun fetchFromNetwork(data: List<SurahItem>): Flow<List<Surah>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<SurahItem>>> {
                return remoteDataSource.getListSurah()
            }

        }.asFlow()
    }

    override fun getDetailSurahWithQuranEditions(number: Int): Flow<Resource<List<QuranEdition>>> {
        return object : NetworkBoundResource<List<QuranEdition>, List<QuranEditionItem>>() {
            override fun fetchFromNetwork(data: List<QuranEditionItem>): Flow<List<QuranEdition>> {
                return DataMapper.mapResponseToDomain(data)
            }

            override suspend fun createCall(): Flow<NetworkResponse<List<QuranEditionItem>>> {
                return remoteDataSource.getDetailSurahWithQuranEditions(number)
            }

        }.asFlow()
    }

}