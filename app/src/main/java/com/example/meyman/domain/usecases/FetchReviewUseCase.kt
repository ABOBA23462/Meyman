package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.ReviewRepository
import javax.inject.Inject

class FetchReviewUseCase @Inject constructor(
    private  val reviewRepository: ReviewRepository
) {
    suspend operator fun invoke() = reviewRepository.fetchReview()
}