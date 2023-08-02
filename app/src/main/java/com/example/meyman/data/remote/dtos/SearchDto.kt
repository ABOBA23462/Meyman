package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<SearchItemDto>
) : Parcelable

@Parcelize
data class SearchItemDto(
    val adults: Int,
    val check_in_date: String,
    val check_out_date: String,
    val children: Int,
    val destination: String,
    val infants: Int,
    val pets: Int,
    val teens: Int
) : Parcelable
