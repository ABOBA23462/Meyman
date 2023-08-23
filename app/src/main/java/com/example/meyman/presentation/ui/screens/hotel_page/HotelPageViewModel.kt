package com.example.meyman.presentation.ui.screens.hotel_page

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.HotelByIdUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.HotelModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HotelPageViewModel @Inject constructor(
    private val hotelByIdUseCase: HotelByIdUseCase
) : ViewModel() {

    private val _hotelValue = MutableStateFlow<Either<String, HotelModel>>(Either.Left())
    val hotelValue = _hotelValue.asStateFlow()

    fun getHotelById(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        hotelByIdUseCase(id).collect {
            when (it) {
                is Either.Left -> {
                    Log.e("ololo", "HotelPageViewModel: $it")
                    _hotelValue.value = Either.Left(it.message)
                }

                is Either.Right -> {
                    Log.e("ololo", "gethotelById: $it")
                    _hotelValue.value = Either.Right(it.data)
                }
            }
        }
    }
}