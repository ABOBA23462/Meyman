package com.example.meyman.presentation.state

import com.example.meyman.domain.utils.models.HotelByIdModel

data class UIStateData(
    val isLoading: Boolean = false,
    val hotelDetail: HotelByIdModel? = null,
    val error: String = ""
)