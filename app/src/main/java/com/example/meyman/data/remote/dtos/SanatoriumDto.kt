package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SanatoriumDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
) : Parcelable

