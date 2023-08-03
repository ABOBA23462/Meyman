package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.SearchRepository
import javax.inject.Inject

class FetchSearchUseCase @Inject constructor(
    private  val searchRepository: SearchRepository
) {
    suspend operator fun invoke() = searchRepository.fetchSearch()
}