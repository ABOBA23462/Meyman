package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.HotelByIdModel
import com.example.meyman.domain.utils.models.HotelsModel
import com.example.meyman.domain.utils.models.HotelsResult
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    suspend fun fetchHotel(): Flow<Either<String, List<HotelsResult>>>
    suspend fun getHotelById(id: Int): Flow<Either<String, HotelByIdModel?>>

}