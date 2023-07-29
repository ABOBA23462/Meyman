package com.example.meyman.data.remote.dtos

data class ReviewDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<ReviewItemDto>
)
data class ReviewItemDto(
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val id: Int,
    val news: Int,
    val stars: Int
)