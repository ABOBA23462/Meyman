package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.HostelDto
import com.example.meyman.domain.models.HostelModel

fun HostelDto.toHostelModel() = HostelModel(
    count,
    next,
    previous,
    results = results.map { it.toTravelItemModel() }
)