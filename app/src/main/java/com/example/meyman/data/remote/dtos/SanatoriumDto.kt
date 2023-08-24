package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.SanatoriumModel

data class SanatoriumDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TravelItemDto>
)

fun SanatoriumDto<TravelItemDto>.toDomain() = SanatoriumModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)