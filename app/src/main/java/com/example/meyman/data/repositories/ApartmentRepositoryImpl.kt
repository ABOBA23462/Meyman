package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.ApartmentApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.ApartmentRepository
import javax.inject.Inject
import javax.inject.Singleton

class ApartmentRepositoryImpl @Inject constructor(
    private val apartmentApiService: ApartmentApiService
) : BaseRepository(), ApartmentRepository {

    override suspend fun fetchApartment() = doRequest {
        apartmentApiService.fetchApartment().results.map{
            it.toDomain()
        }
    }
}