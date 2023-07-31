package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.TransferDto
import com.example.meyman.data.remote.dtos.TransferItemDto
import com.example.meyman.domain.models.TransferItemModel
import com.example.meyman.domain.models.TransferModel

fun TransferDto.toTransferModel() = TransferModel(
    count,
    next,
    previous,
    results = results.map { it.toTransferItemModel() }
)

fun TransferItemDto.toTransferItemModel() = TransferItemModel(
    destination_location,
    different_pickup_places,
    pickup_date,
    pickup_time,
    return_date,
    return_location,
    return_time,
    transfer_location,
    with_driver
)