package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.NewsRepository
import javax.inject.Inject

class FetchNewsUseCase @Inject constructor(
    private  val newsRepository: NewsRepository
) {
    suspend operator fun invoke() = newsRepository.fetchNews()
}