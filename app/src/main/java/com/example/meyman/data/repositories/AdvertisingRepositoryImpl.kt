package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.AdvertisingApiService
import com.example.meyman.data.remote.dtos.home.toDomain
import com.example.meyman.domain.repositories.AdvertisingRepository
import javax.inject.Inject

class AdvertisingRepositoryImpl @Inject constructor(
    private val advertisingApiService: AdvertisingApiService
) : BaseRepository(), AdvertisingRepository {

    override suspend fun getAdvertisingRepository() = doRequest {
        advertisingApiService.fetchAdvertising().results.map { it.toDomain() }
    }
}