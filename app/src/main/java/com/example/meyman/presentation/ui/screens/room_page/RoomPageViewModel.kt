package com.example.meyman.presentation.ui.screens.room_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchDetailRoomUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.rooms.ResultsItemUI
import com.example.meyman.presentation.models.rooms.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RoomPageViewModel @Inject constructor(
    private val fetchDetailUseCase: FetchDetailRoomUseCase
) : ViewModel() {

    private val _establishmentState =
        MutableStateFlow<UIState<ResultsItemUI>>(UIState.Loading())
    val establishmentState = _establishmentState.asStateFlow()

    fun fetchVerification(id: Int) {
        viewModelScope.launch {
            fetchDetailUseCase(id).collect { either ->
                when (either) {
                    is Either.Left<*> ->
                        either.message.let {
                            _establishmentState.value = UIState.Error(either.message.toString())
                        }

                    is Either.Right<*> ->
                        either.data?.let { data ->
                            _establishmentState.value = UIState.Success(
                                data.toUI()
                            )
                        }

                    else -> {}
                }
            }
        }
    }}