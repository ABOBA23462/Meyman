package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<NewsItemDto>
) : Parcelable

@Parcelize
data class NewsItemDto(
    val author_fullname: String,
    val content: String,
    val id: Int,
    val image: String,
    val is_favorite: Boolean,
    val link: String,
    val published_date: String,
    val title: String
) : Parcelable