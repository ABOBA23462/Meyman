package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.HotelByIdModel
import com.example.meyman.domain.utils.models.RoomImageDomain
import com.google.gson.annotations.SerializedName

data class HotelByIdDto(
    @SerializedName("address") val address: String,
    @SerializedName("airport_transfer") val airport_transfer: Boolean,
    @SerializedName("average_rating") val average_rating: Double,
    @SerializedName("bar") val bar: Boolean,
    @SerializedName("cafe") val cafe: Boolean,
    @SerializedName("check_in_time_end") val check_in_time_end: String,
    @SerializedName("check_in_time_start") val check_in_time_start: String,
    @SerializedName("check_out_time_end") val check_out_time_end: String,
    @SerializedName("check_out_time_start") val check_out_time_start: String,
    @SerializedName("free_internet") val free_internet: Boolean,
    @SerializedName("hotel_wide_internet") val hotel_wide_internet: Boolean,
    @SerializedName("housing_images") val housing_images: List<HousingImage>,
    @SerializedName("housing_name") val housing_name: String,
    @SerializedName("id") val id: Int,
    @SerializedName("in_room_internet") val in_room_internet: Boolean,
    @SerializedName("paid_bar") val paid_bar: Boolean,
    @SerializedName("paid_parking") val paid_parking: Boolean,
    @SerializedName("paid_transfer") val paid_transfer: Boolean,
    @SerializedName("park") val park: Boolean,
    @SerializedName("pool") val pool: Boolean,
    @SerializedName("poolside_bar") val poolside_bar: Boolean,
    @SerializedName("restaurant") val restaurant: Boolean,
    @SerializedName("reviews") val reviews: List<Review>,
    @SerializedName("room_service") val room_service: Boolean,
    @SerializedName("room_service") val rooms: List<Room>,
    @SerializedName("spa_services") val spa_services: Boolean,
    @SerializedName("stars") val stars: Int
)

fun HotelByIdDto.toHotelByIdDomain() = HotelByIdModel(
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
    housing_images.map { it.toHousingImageDomain() },
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
    reviews.map { it.toReviewDomain() },
    room_service,
    rooms.map { it.toRoomDomain() },
    spa_services,
    stars
)

data class Room(
    @SerializedName("bed_type") val bed_type: List<String>,
    @SerializedName("max_guest_capacity") val max_guest_capacity: Int,
    @SerializedName("num_rooms") val num_rooms: Int,
    @SerializedName("price_per_night") val price_per_night: String,
    @SerializedName("room_amenities") val room_amenities: List<String>,
    @SerializedName("room_area") val room_area: Int,
    @SerializedName("room_images") val room_images: List<RoomImageData>
)

fun Room.toRoomDomain() = com.example.meyman.domain.utils.models.Room(
    bed_type, max_guest_capacity, num_rooms, price_per_night, room_amenities, room_area, room_images.map { it.toRoomImageDomain() }
)

data class HousingImage(
    @SerializedName("housing") val housing: Int,
    @SerializedName("id_housing") val id: Int,
    @SerializedName("image_housing") val image: String
)

fun HousingImage.toHousingImageDomain() = com.example.meyman.domain.utils.models.HousingImage(
    housing, id, image
)

data class Review(
    @SerializedName("cleanliness_rating") val cleanliness_rating: Int,
    @SerializedName("comfort_rating") val comfort_rating: Int,
    @SerializedName("comment") val comment: String,
    @SerializedName("date_added") val date_added: String,
    @SerializedName("food_rating") val food_rating: Int,
    @SerializedName("housing_review") val housing: Int,
    @SerializedName("location_rating") val location_rating: Int,
    @SerializedName("staff_rating") val staff_rating: Int,
    @SerializedName("user") val user: Int,
    @SerializedName("value_for_money_rating") val value_for_money_rating: Int
)

fun Review.toReviewDomain() = com.example.meyman.domain.utils.models.Review(
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

data class RoomImageData(
    @SerializedName("id_room")
    val id: Int,
    @SerializedName("image_room")
    val image: String,
    @SerializedName("room")
    val room: Int
)

fun RoomImageData.toRoomImageDomain() = RoomImageDomain(
    id, image, room
)