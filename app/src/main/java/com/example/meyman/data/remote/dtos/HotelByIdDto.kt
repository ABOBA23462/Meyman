package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.HotelModel
import com.google.gson.annotations.SerializedName

data class HotelByIdDto(
    @SerializedName("address")
    val address: String,
    @SerializedName("airport_transfer")
    val airport_transfer: Boolean,
    @SerializedName("average_rating")
    val average_rating: Int,
    @SerializedName("bar")
    val bar: Boolean,
    @SerializedName("cafe")
    val cafe: Boolean,
    @SerializedName("check_in_time_end")
    val check_in_time_end: String,
    @SerializedName("check_in_time_start")
    val check_in_time_start: String,
    @SerializedName("check_out_time_end")
    val check_out_time_end: String,
    @SerializedName("check_out_time_start")
    val check_out_time_start: String,
    @SerializedName("free_internet")
    val free_internet: Boolean,
    @SerializedName("hotel_wide_internet")
    val hotel_wide_internet: Boolean,
    @SerializedName("housing_images")
    val housing_images: List<HousingImage>,
    @SerializedName("housing_name")
    val housing_name: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("in_room_internet")
    val in_room_internet: Boolean,
    @SerializedName("in_room_internet")
    val paid_bar: Boolean,
    @SerializedName("paid_parking")
    val paid_parking: Boolean,
    @SerializedName("paid_transfer")
    val paid_transfer: Boolean,
    @SerializedName("paid_transfer")
    val park: Boolean,
    @SerializedName("pool")
    val pool: Boolean,
    @SerializedName("poolside_bar")
    val poolside_bar: Boolean,
    @SerializedName("restaurant")
    val restaurant: Boolean,
    @SerializedName("reviews")
    val reviews: List<Any>,
    @SerializedName("room_service")
    val room_service: Boolean,
    @SerializedName("rooms")
    val rooms: List<Any>,
    @SerializedName("spa_services")
    val spa_services: Boolean,
    @SerializedName("stars")
    val stars: Int
)

fun HotelByIdDto.toHomeDetailModel() = HotelModel(
    id,
    address,
    bar,
    cafe,
    free_internet,
    hotel_wide_internet,
    housing_images,
    housing_name,
    in_room_internet,
    paid_bar,
    paid_parking,
    paid_transfer,
    park,
    pool,
    poolside_bar,
    restaurant,
    reviews,
    room_service,
    rooms,
    spa_services,
    stars
)


data class HousingImage(
    @SerializedName("housing")
    val housing: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String
)