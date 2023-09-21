package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.repositories.TokenRepository
import javax.inject.Inject

class FetchTokenUseCase @Inject constructor(
    private  val tokenRepository: TokenRepository
) {
    operator suspend fun invoke(token : String, tokenDto: RefreshTokenDto) = tokenRepository.fetchToken(token, tokenDto)
}