package com.example.meyman.domain.utils.models

import com.example.meyman.data.remote.dtos.HousingImagesItem

class ResultModel(
    val description: String = "",
    val id: Int = 0,
    val housingImages: List<HousingImagesItem>?,
    val housingName: String = ""
)