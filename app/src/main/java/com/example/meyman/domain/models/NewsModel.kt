package com.example.meyman.domain.models

import com.example.meyman.core.DEFAULT_ID

data class NewsModel(
    val count: Int,
    val next: String,
    val previous: String,
<<<<<<< HEAD
    val results: List<NewsItemModel>
)

data class NewsItemModel(
    val id: Int = DEFAULT_ID,
    val author_fullname: String,
    val content: String,
    val image: String,
    val is_favorite: Boolean,
    val link: String,
    val published_date: String,
    val title: String
)
=======
    val results: List<News>
) {
    data class News(
        val id: Int = DEFAULT_ID,
        val author_fullname: String,
        val content: String,
        val image: String,
        val is_favorite: Boolean,
        val link: String,
        val published_date: String,
        val title: String
    )
}
>>>>>>> ae4c69c (added models from API for the data and domain layers)
