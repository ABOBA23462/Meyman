package com.example.meyman.presentation.ui.screens.booking

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.BookingUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.BookingUI
import com.example.meyman.presentation.models.ResultsBookingUI
import com.example.meyman.presentation.models.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BookingViewModel @Inject constructor(
    private val bookingUseCase: BookingUseCase
) : ViewModel() {

    private val _bookingValue = MutableStateFlow<UIState<List<ResultsBookingUI>>>(UIState.Loading())
    val bookingValue = _bookingValue.asStateFlow()

    fun getBooking() = viewModelScope.launch {
        bookingUseCase.invoke().collect() {
            when (it) {
                is Either.Left -> {
                    _bookingValue.value = UIState.Error(it.message.toString())
                    Log.e("ololo", "getBooking-error: ${it.message.toString()}")
                }

                is Either.Right -> {
                    it.data?.let {
                        _bookingValue.value = UIState.Success(it.map { it.toUI() })
                    }
                    Log.e("ololo", "getBooking-success: ${it.data.toString()}")
                }
            }
        }
    }

}