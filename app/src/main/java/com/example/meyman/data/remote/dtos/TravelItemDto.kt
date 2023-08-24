package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.serialization.SerialName

data class TravelItemDto(
    @SerialName("id")
    val id: String,
    @SerialName("description")
    val description: String,
    @SerialName("housing_name")
    val housing_name: String,
    @SerialName("housing_amenities")
    val housing_amenities: HousingAmenitiesDto,
)

fun TravelItemDto.toDomain() = TravelItemModel(
    id,
    description,
    housing_name,
    housing_amenities.toDomain(),
)
