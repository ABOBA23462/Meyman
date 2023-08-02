package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.SanatoriumDto
import com.example.meyman.domain.models.SanatoriumModel

fun SanatoriumDto.toSanatoriumModel() = SanatoriumModel(
    count,
    next,
    previous,
    results = results.map { it.toTravelItemModel() }
)