package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.SanatoriumsApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.SanatoriumsRepository
import javax.inject.Inject

class SanatoriumsRepositoryImpl @Inject constructor(
    private val sanatoriumsApiService: SanatoriumsApiService
) : BaseRepository(), SanatoriumsRepository {

    override suspend fun fetchSanatoriums() = doRequest {
        sanatoriumsApiService.fetchSanatoriums().results.map{
            it.toDomain()
        }
    }
}