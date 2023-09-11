package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.RegisterRepository
import com.example.meyman.domain.utils.models.RegisterDomain
import javax.inject.Inject

class FetchRegisterUseCase @Inject constructor(
    private  val registerRepository: RegisterRepository
) {
     operator fun invoke(registerDomain: RegisterDomain) = registerRepository.fetchRegister(registerDomain)
}