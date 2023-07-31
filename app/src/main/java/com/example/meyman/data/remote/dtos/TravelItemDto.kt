package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TravelItemDto(
    val accommodation_type: String,
    val bathrooms: Int,
    val bed_type: String,
    val bedrooms: String,
    val beds: Int,
    val description: String,
    val food_type: String,
    val housing_amenities: HousingAmenitiesDto,
    val housing_name: String,
    val housing_type: String,
    val id: Int,
    val image: String,
    val location: String,
    val price_per_night: String,
    val room_amenities: RoomAmenitiesDto
): Parcelable
