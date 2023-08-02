package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.NewsDto
import com.example.meyman.data.remote.dtos.NewsItemDto
import com.example.meyman.domain.models.NewsItemModel
import com.example.meyman.domain.models.NewsModel

fun NewsDto.toModel() = NewsModel(
    count,
    next,
    previous,
    results = results.map { it.toModel() }
)

fun NewsItemDto.toModel() = NewsItemModel(
    id,
    author_fullname,
    content,
    image,
    is_favorite,
    link,
    published_date,
    title
)