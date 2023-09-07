package com.example.meyman.presentation.models.rooms

import com.example.meyman.domain.utils.models.rooms.RoomsModel
import com.google.gson.annotations.SerializedName

data class RoomsUI(
    @SerializedName("next")
    val next: Int = 0,
    @SerializedName("previous")
    val previous: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsRoomsItemUI>?
)

fun RoomsModel.toUI() = RoomsUI(
    next,
    previous,
    count,
    results?.map { it.toUI() }
)