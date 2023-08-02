package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.ApartmentDto
import com.example.meyman.domain.models.ApartmentModel

fun ApartmentDto.toApartmentModel() = ApartmentModel(
    count,
    next,
    previous,
    results = results.map { it.toTravelItemModel() }
)