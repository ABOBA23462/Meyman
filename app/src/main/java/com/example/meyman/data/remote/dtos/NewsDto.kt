package com.example.meyman.data.remote.dtos

data class NewsDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<NewsItemDto>
)
data class NewsItemDto(
    val author_fullname: String,
    val content: String,
    val id: Int,
    val image: String,
    val is_favorite: Boolean,
    val link: String,
    val published_date: String,
    val title: String
)