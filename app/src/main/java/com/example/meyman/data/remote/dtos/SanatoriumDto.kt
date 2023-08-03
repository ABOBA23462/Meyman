package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.SanatoriumModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class SanatoriumDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
) : Parcelable

fun SanatoriumDto<TravelItemDto>.toDomain() = SanatoriumModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)