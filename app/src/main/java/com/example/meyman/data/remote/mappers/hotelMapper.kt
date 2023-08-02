package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.HotelDto
import com.example.meyman.domain.models.HotelModel

fun HotelDto.toHotelModel() = HotelModel(
    count,
    next,
    previous,
    results = results.map { it.toTravelItemModel() }
)