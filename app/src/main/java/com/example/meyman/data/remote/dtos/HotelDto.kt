package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.HotelModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class HotelDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
) : Parcelable

fun HotelDto<TravelItemDto>.toDomain() = HotelModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)