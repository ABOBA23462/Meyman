package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.GuestHouseDto
import com.example.meyman.domain.models.GuestHouseModel

fun GuestHouseDto.toGuestHouseModel() = GuestHouseModel(
    count,
    next,
    previous,
    results = results.map { it.toTravelItemModel() }
)