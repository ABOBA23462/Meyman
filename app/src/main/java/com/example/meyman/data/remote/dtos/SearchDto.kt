package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.SearchItemModel
import com.example.meyman.domain.utils.models.SearchModel

data class SearchDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<SearchItemDto>
)


fun SearchDto<SearchItemDto>.toDomain() = SearchModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)

data class SearchItemDto(
    val adults: Int,
    val check_in_date: String,
    val check_out_date: String,
    val children: Int,
    val destination: String,
    val infants: Int,
    val pets: Int,
    val teens: Int
)

fun SearchItemDto.toDomain() = SearchItemModel(
    adults,
    check_in_date,
    check_out_date,
    children,
    destination,
    infants,
    pets,
    teens
)