package com.example.meyman.domain.utils.models

import com.example.meyman.data.remote.dtos2.HousingImage

class ResultModel(
    val accommodation_type: String,
    val address: String,
    val average_rating: Double,
    val breakfast_cost_usd: Any,
    val breakfast_included: Boolean,
    val breakfast_offered: Boolean,
    val breakfast_type: List<Any>,
    val check_in_time_end: Int,
    val check_in_time_start: Int,
    val check_out_time_end: Int,
    val check_out_time_start: Int,
    val children_allowed: Boolean,
    val description: String,
    val food_type: String,
    val housing_amenities: List<String>,
//    val housing_images: List<HousingImage>,
    val housing_name: String,
    val housing_type: String,
    val id: Int,
    val parking: String,
    val parking_cost_usd: Any,
    val parking_location: String,
    val pet_fee: Boolean,
    val pets_allowed: Boolean,
    val region: String,
    val slug: String,
    val stars: Int
)