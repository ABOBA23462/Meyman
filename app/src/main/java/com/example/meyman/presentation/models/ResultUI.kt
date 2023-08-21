package com.example.meyman.presentation.models

import com.example.meyman.data.remote.dtos.HousingImagesItem
import com.example.meyman.domain.utils.models.ResultModel
import com.squareup.moshi.Json

data class ResultUI(
    @Json(name = "description")
    val description: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "housing_images")
    val housingImages: List<HousingImagesItem>?,
    @Json(name = "housing_name")
    val housingName: String = ""
)

fun ResultModel.toUI() = ResultUI(
    description,
    id,
    housingImages,
    housingName
)