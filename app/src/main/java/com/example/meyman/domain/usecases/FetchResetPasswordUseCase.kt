package com.example.meyman.domain.usecases

import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.domain.repositories.LoginRepository
import com.example.meyman.domain.repositories.ResetPasswordRepository
import javax.inject.Inject

class FetchResetPasswordUseCase@Inject constructor(
    private  val resetPasswordRepository: ResetPasswordRepository
) {
    operator suspend fun invoke(passwordDto: PasswordDto) = resetPasswordRepository.fetchResetPassword(passwordDto)
}