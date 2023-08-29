package com.example.meyman.presentation.models

import com.example.meyman.domain.utils.models.HotelByIdModel
import com.example.meyman.domain.utils.models.HousingImage
import com.example.meyman.domain.utils.models.Review
import com.example.meyman.domain.utils.models.Room

data class HotelByIdUI(
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
    val housing_images: List<HousingImageUI>,
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
    val reviews: List<ReviewUI>,
    val room_service: Boolean,
    val rooms: List<RoomUI>,
    val spa_services: Boolean,
    val stars: Int
)

fun HotelByIdModel.hotelByIdUI() = HotelByIdUI(
    address,
    airport_transfer,
    average_rating,
    bar,
    cafe,
    check_in_time_end,
    check_in_time_start,
    check_out_time_end,
    check_out_time_start,
    free_internet,
    hotel_wide_internet,
    housing_images.map { it.toHousingImageUI() },
    housing_name,
    id,
    in_room_internet,
    paid_bar,
    paid_parking,
    paid_transfer,
    park,
    pool,
    poolside_bar,
    restaurant,
    reviews.map { it.toReviewUI() },
    room_service,
    rooms.map { it.roomUI() },
    spa_services,
    stars
)

data class HousingImageUI(
    val housing: Int,
    val id: Int,
    val image: String
)

fun HousingImage.toHousingImageUI() = HousingImageUI(
    housing, id, image
)

data class ReviewUI(
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

fun Review.toReviewUI() = ReviewUI(
    cleanliness_rating,
    comfort_rating,
    comment,
    date_added,
    food_rating,
    housing,
    location_rating,
    staff_rating,
    user,
    value_for_money_rating
)

data class RoomUI(
    val bed_type: List<String>,
    val max_guest_capacity: Int,
    val num_rooms: Int,
    val price_per_night: String,
    val room_amenities: List<String>,
    val room_area: Int,
    val room_images: List<RoomImageUI>
)

fun Room.roomUI() = RoomUI(
    bed_type,
    max_guest_capacity,
    num_rooms,
    price_per_night,
    room_amenities,
    room_area,
    room_images.map { it.toRoomImageUI() }
)

data class RoomImageUI(
    val id: Int,
    val image: String,
    val room: Int
)

fun com.example.meyman.domain.utils.models.RoomImage.toRoomImageUI() = RoomImageUI(
    id, image, room
)
