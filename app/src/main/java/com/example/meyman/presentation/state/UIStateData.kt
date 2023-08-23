package com.example.meyman.presentation.state

import com.example.meyman.domain.utils.models.HotelModel

data class UIStateData(
    val isLoading: Boolean = false,
    val hotelDetail: HotelModel? = null,
    val error: String = ""
)