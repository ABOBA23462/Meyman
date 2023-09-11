package com.example.meyman.presentation.ui.screens.sign.`in`

import androidx.lifecycle.ViewModel
import com.example.meyman.domain.usecases.FetchRegisterUseCase
import com.example.meyman.domain.utils.models.RegisterDomain
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor( private val registerUseCase : FetchRegisterUseCase) : ViewModel() {

    fun getRegisterState(registerDomain: RegisterDomain) = registerUseCase(registerDomain)
}
