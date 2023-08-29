package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ChooseRoomRepository
import com.example.meyman.domain.repositories.RoomsRepository
import javax.inject.Inject

class FetchChooseRoomUseCase  @Inject constructor(
    private val chooseRoomRepository: ChooseRoomRepository
){
    suspend operator fun invoke() = chooseRoomRepository.getChooseRepository()
}