package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import javax.inject.Inject

class FetchApartmentUseCase @Inject constructor(
    private  val apartmentRepository: ApartmentRepository
) {
    suspend operator fun invoke() = apartmentRepository.fetchApartment()
}