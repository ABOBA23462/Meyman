package com.example.meyman.presentation.ui.screens.hotel_page

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.HotelByIdUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.HotelsResult
import com.example.meyman.presentation.models.HotelByIdUI
import com.example.meyman.presentation.models.auth.toUI
import com.example.meyman.presentation.models.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelPageViewModel @Inject constructor(
    private val hotelByIdUseCase: HotelByIdUseCase
) : ViewModel() {

    private val _hotelValue = MutableStateFlow<UIState<HotelsResult>>(UIState.Loading())
    val hotelValue = _hotelValue.asStateFlow()

    fun getHotelById(id: Int) = viewModelScope.launch {
        hotelByIdUseCase(id).collect {
            when (it) {
                is Either.Left -> {
                    _hotelValue.value = UIState.Error(it.message.toString())
                    Log.e("ololo", "HotelPageViewModel-left: $it")
                }

                is Either.Right -> {
                    it.data?.let {
                        _hotelValue.value = UIState.Success(it.toUI())
                    }
                    Log.e("ololo", "HotelPageViewModel-right: $it")
                }
            }
        }
    }
}