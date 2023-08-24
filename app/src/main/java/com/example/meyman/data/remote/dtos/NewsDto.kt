package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.NewsItemModel
import com.example.meyman.domain.utils.models.NewsModel
import kotlinx.parcelize.Parcelize

data class NewsDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<NewsItemDto>
)

fun NewsDto<NewsItemDto>.toDomain() = NewsModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
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

fun NewsItemDto.toDomain() = NewsItemModel(
    id,
    author_fullname,
    content,
    image,
    is_favorite,
    link,
    published_date,
    title
)