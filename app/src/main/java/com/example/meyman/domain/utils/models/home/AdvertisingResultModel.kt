package com.example.meyman.domain.utils.models.home

data class AdvertisingResultModel(
    val checkOutTimeEnd: String = "",
    val roomService: Boolean = false,
//    val parkingLocation: String,
    val accommodationType: String = "",
    val petFee: Boolean = false,
    val housing: Int = 0,
    val added: Boolean = false,
    val paidParking: Boolean = false,
    val poolsideBar: Boolean = false,
    val childrenAllowed: Boolean = false,
    val breakfastIncluded: Boolean = false,
    val spaServices: Boolean = false,
    val bar: Boolean = false,
    val inRoomInternet: Boolean = false,
    val checkOutTimeStart: String = "",
    val id: Int = 0,
    val freeInternet: Boolean = false,
    val park: Boolean = false,
    val breakfastOffered: Boolean = false,
    val checkInTimeEnd: String = "",
//    val cheapestRoomPrice: Int,
    val airportTransfer: Boolean = false,
    val address: String = "",
    val paidTransfer: Boolean = false,
    val childrenPlayground: Boolean = false,
    val restaurant: Boolean = false,
    val pool: Boolean = false,
    val petsAllowed: Boolean = false,
    val housingImage: List<String>?,
    val stars: Int = 0,
    val foodType: String = "",
    val checkInTimeStart: String = "",
    val housingName: String = "",
    val cafe: Boolean = false,
    val hotelWideInternet: Boolean = false,
    val carRental: Boolean = false,
    val gym: Boolean = false,
    val paidBar: Boolean = false,
//    val breakfastCostUsd: Int,
    val region: String = "",
    val housingType: String = ""
)