package com.example.meyman.presentation.ui.screens.profile.user.change

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchChangeUserProfileUseCase
import com.example.meyman.domain.usecases.FetchUserProfileUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.profile.ChangeUserProfileUI
import com.example.meyman.presentation.models.profile.UserProfileUI
import com.example.meyman.presentation.models.profile.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

@HiltViewModel
class ChangeUserProfileViewModel @Inject constructor(
    private val useCase: FetchChangeUserProfileUseCase
) : ViewModel() {

    private val _changeUserProfileState =
        MutableStateFlow<UIState<ChangeUserProfileUI>>(UIState.Loading())
    val changeUserProfileState = _changeUserProfileState.asStateFlow()

    fun fetchUserProfile(
        token: String,
        image: MultipartBody.Part?,
        username: RequestBody,
        phoneNumber: RequestBody
    ) = viewModelScope.launch {
        useCase(token,
            image,
            username, phoneNumber).collect {
            when (it) {
                is Either.Left -> {
                    _changeUserProfileState.value = UIState.Error(it.message.toString())
                }

                is Either.Right -> {
                    it.data?.let {
                        _changeUserProfileState.value = UIState.Success(it.toUI())
                    }
                }
            }
        }
    }
}