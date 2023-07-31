package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.ReviewDto
import com.example.meyman.data.remote.dtos.ReviewItemDto
import com.example.meyman.domain.models.ReviewItemModel
import com.example.meyman.domain.models.ReviewModel

fun ReviewDto.toReviewModel() = ReviewModel(
    count,
    next,
    previous,
    results = results.map { it.toReviewItemModel() }
)

fun ReviewItemDto.toReviewItemModel() = ReviewItemModel(
    id,
    comment,
    formatted_date_added,
    hotel,
    news,
    stars
)