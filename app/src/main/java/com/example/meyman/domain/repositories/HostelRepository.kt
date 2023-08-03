package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.coroutines.flow.Flow

interface HostelRepository {
    suspend fun fetchHostel(): Flow<Either<String, List<TravelItemModel>>>

}