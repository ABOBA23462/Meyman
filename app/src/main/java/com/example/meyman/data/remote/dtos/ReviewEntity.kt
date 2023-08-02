package com.example.meyman.data.remote.dtos

data class ReviewEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Review>
) {
    data class Review(
        val comment: String,
        val formatted_date_added: String,
        val hotel: String,
        val id: Int,
        val news: Int,
        val stars: Int
    )
}