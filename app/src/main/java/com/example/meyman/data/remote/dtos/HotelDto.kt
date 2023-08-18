package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.HotelModel
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue
import kotlinx.serialization.SerialName

data class HotelDto<T>(
    @SerialName("count")
    val count: Int,
    @SerialName("next")
    val next: String,
    @SerialName("previous")
    val previous: String,
    @SerialName("results")
    val results: List<T>
)
