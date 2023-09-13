package com.example.meyman.presentation.ui.screens.sign.`in`

import androidx.lifecycle.ViewModel
import com.example.meyman.data.remote.dtos.RegisterDto
import com.example.meyman.domain.usecases.FetchRegisterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor( private val registerUseCase : FetchRegisterUseCase) : ViewModel() {

   suspend fun getRegisterState(registerDomain: RegisterDto) = registerUseCase(registerDomain)
}
