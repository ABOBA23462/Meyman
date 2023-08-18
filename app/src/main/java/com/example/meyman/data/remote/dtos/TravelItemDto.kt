package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName

@Parcelize
data class TravelItemDto(
    @SerialName("id")
    val id: String,
    @SerialName("description")
    val description: String,
    @SerialName("housing_name")
    val housing_name: String,
    @SerialName("housing_amenities")
    val housing_amenities: HousingAmenitiesDto,
) : Parcelable

fun TravelItemDto.toDomain() = TravelItemModel(
    id,
    description,
    housing_name,
    housing_amenities.toDomain(),
)
