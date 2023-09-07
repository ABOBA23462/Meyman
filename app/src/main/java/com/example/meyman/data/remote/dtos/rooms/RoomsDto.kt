package com.example.meyman.data.remote.dtos.rooms

import com.example.meyman.domain.utils.models.rooms.RoomsModel
import com.google.gson.annotations.SerializedName

data class RoomsDto(
    @SerializedName("next")
    val next: Int = 0,
    @SerializedName("previous")
    val previous: Int = 0,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsRoomsItemDto>?
)

fun RoomsDto.toDomain() = RoomsModel(
    next,
    previous,
    count,
    results?.map { it.toDomain() }
)