package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.ApartmentModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ApartmentDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
): Parcelable

fun ApartmentDto<TransferItemDto>.toDomain() = ApartmentModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)