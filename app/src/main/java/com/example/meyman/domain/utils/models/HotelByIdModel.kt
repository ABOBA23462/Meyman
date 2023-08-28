package com.example.meyman.domain.utils.models

import com.example.meyman.data.remote.dtos.HousingImage
import com.example.meyman.data.remote.dtos.RoomImage


data class HotelByIdModel(
    val address: String,
    val airport_transfer: Boolean,
    val average_rating: Double,
    val bar: Boolean,
    val cafe: Boolean,
    val check_in_time_end: String,
    val check_in_time_start: String,
    val check_out_time_end: String,
    val check_out_time_start: String,
    val free_internet: Boolean,
    val hotel_wide_internet: Boolean,
    val housing_images: List<HousingImage>,
    val housing_name: String,
    val id: Int,
    val in_room_internet: Boolean,
    val paid_bar: Boolean,
    val paid_parking: Boolean,
    val paid_transfer: Boolean,
    val park: Boolean,
    val pool: Boolean,
    val poolside_bar: Boolean,
    val restaurant: Boolean,
    val reviews: List<Review>,
    val room_service: Boolean,
    val rooms: List<Room>,
    val spa_services: Boolean,
    val stars: Int
)

data class Room(
    val bed_type: List<String>,
    val max_guest_capacity: Int,
    val num_rooms: Int,
    val price_per_night: String,
    val room_amenities: List<String>,
    val room_area: Int,
    val room_images: List<RoomImage>
)

data class HousingImage(
    val housing: Int,
    val id: Int,
    val image: String
)

data class Review(
    val cleanliness_rating: Int,
    val comfort_rating: Int,
    val comment: String,
    val date_added: String,
    val food_rating: Int,
    val housing: Int,
    val location_rating: Int,
    val staff_rating: Int,
    val user: Int,
    val value_for_money_rating: Int
)