package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.ResultModel

data class HotelsDto(
    val next: String = "",
    val previous: String = "",
    val count: Int = 0,
    val results: List<ResultsItem>?
)

data class ResultsItem(
    val description: String = "",
    val id: Int = 0,
    val housingImages: List<HousingImagesItem>?,
    val housingName: String = ""
)

fun ResultsItem.toDomain() = ResultModel(
    description,
    id,
    housingImages,
    housingName

)

data class HousingImagesItem(
    val image: String = "",
    val housing: Int = 0,
    val id: Int = 0
)