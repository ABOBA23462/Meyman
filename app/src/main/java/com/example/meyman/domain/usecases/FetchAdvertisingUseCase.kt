package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.AdvertisingRepository
import com.example.meyman.domain.repositories.ChooseRoomRepository
import javax.inject.Inject

class FetchAdvertisingUseCase  @Inject constructor(
    private val advertisingRepository: AdvertisingRepository
){
    suspend operator fun invoke() = advertisingRepository.getAdvertisingRepository()
}