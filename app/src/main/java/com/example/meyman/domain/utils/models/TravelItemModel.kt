package com.example.meyman.domain.utils.models

import com.example.meyman.core.Constant
import com.example.meyman.domain.models.RoomAmenitiesModel

data class TravelItemModel(
    val id: Int = Constant.DEFAULT_ID,
    val accommodation_type: String,
    val bathrooms: Int,
    val bed_type: String,
    val bedrooms: String,
    val beds: Int,
    val description: String,
    val food_type: String,
    val housing_amenities: HousingAmenitiesModel,
    val housing_name: String,
    val housing_type: String,
    val image: String,
    val location: String,
    val price_per_night: String,
    val room_amenities: RoomAmenitiesModel
)
