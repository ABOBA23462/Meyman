package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.TransferItemModel
import com.example.meyman.domain.utils.models.TransferModel
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransferDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TransferItemDto>
) : Parcelable

fun TransferDto<TravelItemDto>.toDomain() = TransferModel(
    count,
    next,
    previous,
    results = results.map { it.toDomain() }
)

@Parcelize
data class TransferItemDto(
    val destination_location: String,
    val different_pickup_places: Boolean,
    val pickup_date: String,
    val pickup_time: String,
    val return_date: String,
    val return_location: String,
    val return_time: String,
    val transfer_location: String,
    val with_driver: Boolean
) : Parcelable

fun TransferItemDto.toDomain() = TransferItemModel(
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