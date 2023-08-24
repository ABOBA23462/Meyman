package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.ReviewItemModel
import kotlinx.parcelize.Parcelize

data class ReviewDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReviewItemDto>
)

//fun ReviewDto<Any?>.toDomain() = ReviewModel(
//    count,
//    next,
//    previous,
//    results = results.map { it.toDomain() }
//)

data class ReviewItemDto(
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val id: Int,
    val news: Int,
    val stars: Int
)

fun ReviewItemDto.toDomain() = ReviewItemModel(
    id,
    comment,
    formatted_date_added,
    hotel,
    news,
    stars
)