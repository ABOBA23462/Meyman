package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.RegisterDto
import com.example.meyman.domain.repositories.RegisterRepository
import javax.inject.Inject

class FetchRegisterUseCase @Inject constructor(
    private  val registerRepository: RegisterRepository
) {
    operator suspend fun invoke(registerDto: RegisterDto) = registerRepository.fetchRegister(registerDto)
}