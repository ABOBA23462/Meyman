package com.example.meyman.domain.models

import com.example.meyman.core.DEFAULT_ID

data class HotelModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemModel>
)
