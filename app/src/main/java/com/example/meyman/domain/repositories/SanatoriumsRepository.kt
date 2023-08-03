package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.coroutines.flow.Flow

interface SanatoriumsRepository {

    suspend fun fetchSanatoriums(): Flow<Either<String, List<TravelItemModel>>>

}