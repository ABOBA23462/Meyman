package com.example.meyman.domain.utils.models.rooms

data class RoomsModel(
    val next: Int = 0,
    val previous: Int = 0,
    val count: Int = 0,
    val results: List<ResultsRoomsItemModel>?
)