package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.ResponseState
import com.example.meyman.domain.utils.models.HotelModel
import com.example.meyman.domain.utils.models.ResultModel
import kotlinx.coroutines.flow.Flow

interface HotelRepository {

    suspend fun fetchHotel(): Flow<Either<String, List<ResultModel>?>>
    suspend fun getHotelById(id: Int): Flow<Either<String, HotelModel>>

}