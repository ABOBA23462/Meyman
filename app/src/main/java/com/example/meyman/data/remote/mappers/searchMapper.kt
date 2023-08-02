package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.SearchDto
import com.example.meyman.data.remote.dtos.SearchItemDto
import com.example.meyman.domain.models.SearchItemModel
import com.example.meyman.domain.models.SearchModel

fun SearchDto.toSearchModel() = SearchModel(
    count,
    next,
    previous,
    results = results.map { it.toSearchItemModel() }
)

fun SearchItemDto.toSearchItemModel() = SearchItemModel(
    adults,
    check_in_date,
    check_out_date,
    children,
    destination,
    infants,
    pets,
    teens
)