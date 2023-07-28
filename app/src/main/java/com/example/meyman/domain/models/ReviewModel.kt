package com.example.meyman.domain.models

import com.example.meyman.core.DEFAULT_ID

data class ReviewModel(
    val count: Int,
    val next: String,
    val previous: String,
<<<<<<< HEAD
    val results: List<ReviewItemModel>
)

data class ReviewItemModel(
    val id: Int = DEFAULT_ID,
    val comment: String,
    val formatted_date_added: String,
    val hotel: String,
    val news: Int,
    val stars: Int
)
=======
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
>>>>>>> ae4c69c (added models from API for the data and domain layers)
