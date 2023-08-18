package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.ReviewItemModel
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    suspend fun fetchReview(): Flow<Either<String, List<ReviewItemModel>>>
}