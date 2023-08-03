package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.coroutines.flow.Flow

interface ApartmentRepository {

    suspend fun fetchApartment(): Flow<Either<String, List<TravelItemModel>>>

}