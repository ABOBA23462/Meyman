package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TransferDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<TransferItemDto>
) : Parcelable

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
