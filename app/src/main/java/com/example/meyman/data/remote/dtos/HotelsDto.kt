package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.ResultModel
import com.squareup.moshi.Json

data class HotelsDto(
    @Json(name = "next")
    val next: String = "",
    @Json(name = "previous")
    val previous: String = "",
    @Json(name = "count")
    val count: Int = 0,
    @Json(name = "results")
    val results: List<ResultsItem>?
)

data class ResultsItem(
    @Json(name = "description")
    val description: String = "",
    @Json(name = "id")
    val id: Int = 0,
    @Json(name = "housing_images")
    val housingImages: List<HousingImagesItem>?,
    @Json(name = "housing_name")
    val housingName: String = ""
)

fun ResultsItem.toDomain() = ResultModel(
    description,
    id,
    housingImages,
    housingName

)

data class HousingImagesItem(
    @Json(name = "image")
    val image: String = "",
    @Json(name = "housing")
    val housing: Int = 0,
    @Json(name = "id")
    val id: Int = 0
)