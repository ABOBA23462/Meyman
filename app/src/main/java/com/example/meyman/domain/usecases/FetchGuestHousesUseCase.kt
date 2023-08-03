package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.GuestHousesRepository
import javax.inject.Inject

class FetchGuestHousesUseCase @Inject constructor(
    private  val guestHousesRepository: GuestHousesRepository
) {
    suspend operator fun invoke() = guestHousesRepository.fetchGuestHouses()
}