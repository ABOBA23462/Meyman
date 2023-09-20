package com.example.meyman.presentation.models.rooms.list

import com.example.meyman.domain.utils.models.rooms.list.ResultsRoomsListItemModel
import com.example.meyman.domain.utils.models.rooms.list.RoomListImagesItemModel
import com.example.meyman.domain.utils.models.rooms.list.RoomListModel
import com.google.gson.annotations.SerializedName

data class RoomListUI<T>(
    @SerializedName("next")
    val next: String = "",
    @SerializedName("previous")
    val previous: String,
    @SerializedName("count")
    val count: Int = 0,
    @SerializedName("results")
    val results: List<ResultsRoomsListItemUI>?
)

fun RoomListModel.toUI() = RoomListUI<ResultsRoomsListItemUI>(
    next,
    previous,
    count,
    results?.map { it.toUI() }
)

data class ResultsRoomsListItemUI(
//    @SerializedName("king_bed")
//    val kingBed: String,
    @SerializedName("room_amenities")
    val roomAmenities: List<String>?,
//    @SerializedName("queen_bed")
//    val queenBed: String,
    @SerializedName("max_guest_capacity")
    val maxGuestCapacity: Int = 0,
    @SerializedName("smoking_allowed")
    val smokingAllowed: Boolean = false,
    @SerializedName("housing")
    val housing: Int = 0,
    @SerializedName("bed_type")
    val bedType: List<String>?,
    @SerializedName("room_area")
    val roomArea: Int = 0,
    @SerializedName("num_rooms")
    val numRooms: Int = 0,
    @SerializedName("bedrooms")
    val bedrooms: String = "",
    @SerializedName("room_name")
    val roomName: String = "",
    @SerializedName("single_bed")
    val singleBed: Int = 0,
    @SerializedName("Free_cancellation_anytime")
    val freeCancellationAnytime: Boolean = false,
//    @SerializedName("sofa_bed")
//    val sofaBed: String,
    @SerializedName("outside")
    val outside: List<String>?,
    @SerializedName("price_per_night")
    val pricePerNight: String = "",
    @SerializedName("room_images")
    val roomImages: List<RoomListImagesItemUI>?,
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("kitchen")
    val kitchen: List<String>?,
    @SerializedName("double_bed")
    val doubleBed: Int = 0,
    @SerializedName("bathroom")
    val bathroom: List<String>?
)

fun ResultsRoomsListItemModel.toUI() = ResultsRoomsListItemUI(
//    kingBed,
    roomAmenities,
//    queenBed,
    maxGuestCapacity,
    smokingAllowed,
    housing,
    bedType,
    roomArea,
    numRooms,
    bedrooms,
    roomName,
    singleBed,
    freeCancellationAnytime,
//    sofaBed,
    outside,
    pricePerNight,
    roomImages?.map { it.toUI() },
    id,
    kitchen,
    doubleBed,
    bathroom
)

data class RoomListImagesItemUI(
    @SerializedName("image")
    val image: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("room")
    val room: Int = 0
)

fun RoomListImagesItemModel.toUI() = RoomListImagesItemUI(
    image,
    id,
    room
)