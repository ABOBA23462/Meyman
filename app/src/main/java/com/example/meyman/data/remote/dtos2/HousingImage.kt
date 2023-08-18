package com.example.meyman.data.remote.dtos2

import com.example.meyman.domain.utils.models.HousingImageModel

data class HousingImage(
    val housing: Int,
    val id: Int,
    val image: String
)

fun HousingImage.toDomain() = HousingImageModel(
    housing,
    id,
    image
)