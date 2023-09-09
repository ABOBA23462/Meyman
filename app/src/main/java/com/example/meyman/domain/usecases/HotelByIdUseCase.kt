package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject

class HotelByIdUseCase @Inject constructor(
    private val hotelRepository: HotelRepository
) {

    suspend operator fun invoke(id: Int) = hotelRepository.getHotelById(id)


}