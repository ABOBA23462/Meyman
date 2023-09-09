package com.example.meyman.presentation.ui.screens.search_results

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meyman.domain.usecases.FetchHotelUseCase
import com.example.meyman.domain.utils.Either
import com.example.meyman.presentation.models.HotelsResult
import com.example.meyman.presentation.models.HotelsUI
import com.example.meyman.presentation.models.toUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchResultViewModel @Inject constructor(
    private val fetchHotelUseCase: FetchHotelUseCase
) : ViewModel() {

    private val _hotelState = MutableStateFlow<UIState<List<HotelsResult>>>(UIState.Loading())
    val hotelState get() = _hotelState.asStateFlow()

    init {
        fetchHotel()
    }

    private fun fetchHotel() {
        viewModelScope.launch {
            fetchHotelUseCase.invoke().collect {
                when (it) {
                    is Either.Left -> {
                        Log.e("ololo", "fetchHotel: $it")
                        it.message?.let { error ->
                            _hotelState.value = UIState.Error(error)
                        }
                    }

                    is Either.Right -> {
                        Log.e("ololo", it.data.toString())

                        it.data?.let {
                            _hotelState.value = UIState.Success(it.map { hotel ->
                                hotel.toUI()
                            })
                        }

                    }
                }
            }
        }
    }
}