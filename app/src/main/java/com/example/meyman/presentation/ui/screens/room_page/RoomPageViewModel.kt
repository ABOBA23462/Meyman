package com.example.meyman.presentation.ui.screens.room_page

import androidx.lifecycle.ViewModel
import com.example.meyman.domain.usecases.FetchDetailRoomUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RoomPageViewModel @Inject constructor(
    private val fetchDetailUseCase: FetchDetailRoomUseCase
) : ViewModel() {

    fun fetchDetail(id: Int) = fetchDetailUseCase.invoke(id)
}