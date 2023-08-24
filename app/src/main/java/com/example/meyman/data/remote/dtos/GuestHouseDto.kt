package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.GuestHouseModel
import kotlinx.parcelize.Parcelize

data class GuestHouseDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
)

fun GuestHouseDto<TravelItemDto>.toDomain() = GuestHouseModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)

