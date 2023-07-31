package com.example.meyman.domain.models

data class GuestHouseModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemModel>
)