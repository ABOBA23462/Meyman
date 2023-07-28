package com.example.meyman.domain.models

import com.example.meyman.core.DEFAULT_ID

data class ReviewModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Review>
) {
    data class Review(
        val id: Int = DEFAULT_ID,
        val comment: String,
        val formatted_date_added: String,
        val hotel: String,
        val news: Int,
        val stars: Int
    )
}