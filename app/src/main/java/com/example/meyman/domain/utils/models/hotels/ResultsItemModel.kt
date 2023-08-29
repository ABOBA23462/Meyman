package com.example.meyman.domain.utils.models.hotels


data class ResultsItemModel(
    val checkOutTimeEnd: String = "",
    val roomService: Boolean = false,
    val rooms: List<RoomsItemModel>?,
    val paidParking: Boolean = false,
    val poolsideBar: Boolean = false,
    val spaServices: Boolean = false,
    val bar: Boolean = false,
    val inRoomInternet: Boolean = false,
    val checkOutTimeStart: String = "",
    val id: Int = 0,
    val housingImages: List<HousingImagesItemModel>?,
    val freeInternet: Boolean = false,
    val park: Boolean = false,
    val checkInTimeEnd: String = "",
    val airportTransfer: Boolean = false,
    val paidTransfer: Boolean = false,
    val address: String = "",
    val restaurant: Boolean = false,
    val pool: Boolean = false,
    val averageRating: Int = 0,
    val stars: Int = 0,
    val checkInTimeStart: String = "",
    val housingName: String = "",
    val cafe: Boolean = false,
    val hotelWideInternet: Boolean = false,
    val paidBar: Boolean = false
)