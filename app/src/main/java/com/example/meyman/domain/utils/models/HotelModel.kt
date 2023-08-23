package com.example.meyman.domain.utils.models

import com.example.meyman.data.remote.dtos.HousingImage


data class HotelModel(
    val id: Int,
    val address: String,
    val bar: Boolean,
    val cafe: Boolean,
    val free_internet: Boolean,
    val hotel_wide_internet: Boolean,
    val housing_images: List<HousingImage>,
    val housing_name: String,
    val in_room_internet: Boolean,
    val paid_bar: Boolean,
    val paid_parking: Boolean,
    val paid_transfer: Boolean,
    val park: Boolean,
    val pool: Boolean,
    val poolside_bar: Boolean,
    val restaurant: Boolean,
    val reviews: List<Any>,
    val room_service: Boolean,
    val rooms: List<Any>,
    val spa_services: Boolean,
    val stars: Int
    )
