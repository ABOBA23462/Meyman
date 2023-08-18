package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.HotelApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.data.remote.dtos2.toDomain
import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HotelRepositoryImpl @Inject constructor(
    private val hotelApiService: HotelApiService
) : BaseRepository(), HotelRepository {

    override suspend fun fetchHotel() = doRequest {
        hotelApiService.getHotelResult().results.map{
            it.toDomain()
        }
    }
}