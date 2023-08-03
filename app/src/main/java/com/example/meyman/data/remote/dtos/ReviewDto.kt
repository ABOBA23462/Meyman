package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.ReviewItemModel
import com.example.meyman.domain.utils.models.ReviewModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class ReviewDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReviewItemDto>
) : Parcelable

fun ReviewDto<Any?>.toDomain() = ReviewModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)

@Parcelize
data class ReviewItemDto(
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val id: Int,
    val news: Int,
    val stars: Int
) : Parcelable

fun ReviewItemDto.toDomain() = ReviewItemModel(
    id,
    comment,
    formatted_date_added,
    hotel,
    news,
    stars
)