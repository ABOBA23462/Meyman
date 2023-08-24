package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.HostelModel
import kotlinx.parcelize.Parcelize

data class HostelDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
)

fun HostelDto<TravelItemDto>.toDomain() = HostelModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)