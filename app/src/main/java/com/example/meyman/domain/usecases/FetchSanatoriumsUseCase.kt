package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.SanatoriumsRepository
import javax.inject.Inject

class FetchSanatoriumsUseCase @Inject constructor(
    private  val sanatoriumsRepository: SanatoriumsRepository
) {
    suspend operator fun invoke() = sanatoriumsRepository.fetchSanatoriums()
}