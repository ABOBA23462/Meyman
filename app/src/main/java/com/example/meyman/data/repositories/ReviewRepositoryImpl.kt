package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.ReviewApiService
import com.example.meyman.data.remote.dtos.review.toDomain
import com.example.meyman.domain.repositories.ReviewRepository
import javax.inject.Inject

class ReviewRepositoryImpl @Inject constructor(
    private val reviewApiService: ReviewApiService
) : BaseRepository(), ReviewRepository {

    override fun fetchReview() = doRequest {
        reviewApiService.fetchReview().results?.map{ it.toDomain() }
    }
}