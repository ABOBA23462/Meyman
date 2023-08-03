package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.HostelsApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.HostelRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HostelsRepositoryImpl @Inject constructor(
    private val hostelApiService: HostelsApiService
) : BaseRepository(), HostelRepository {

    override suspend fun fetchHostel() = doRequest {
        hostelApiService.fetchHostels().results.map{
            it.toDomain()
        }
    }
}