package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReviewItemDto>
) : Parcelable

@Parcelize
data class ReviewItemDto(
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val id: Int,
    val news: Int,
    val stars: Int
) : Parcelable