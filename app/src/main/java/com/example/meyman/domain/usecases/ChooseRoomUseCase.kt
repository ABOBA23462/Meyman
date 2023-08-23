package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ChooseRoomRepository
import javax.inject.Inject

class ChooseRoomUseCase  @Inject constructor(
    private val chooseRoomRepository: ChooseRoomRepository
){
    suspend operator fun invoke() = chooseRoomRepository.getChooseRepository()
}