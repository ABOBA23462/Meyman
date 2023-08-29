package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.ReviewItemModel
import com.example.meyman.domain.utils.models.review.ResultsReviewItemModel
import kotlinx.coroutines.flow.Flow

interface ReviewRepository {

    suspend fun fetchReview(): Flow<Either<String, List<ResultsReviewItemModel>?>>
}