package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.GuestHousesApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.GuestHousesRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GuestHousesRepositoryImpl @Inject constructor(
    private val guestHousesApiService: GuestHousesApiService
) : BaseRepository(), GuestHousesRepository {

    override suspend fun fetchGuestHouses() = doRequest {
        guestHousesApiService.fetchGustHouses().results.map{
            it.toDomain()
        }
    }
}