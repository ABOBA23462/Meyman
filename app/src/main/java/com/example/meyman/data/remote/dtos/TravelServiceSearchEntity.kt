package com.example.meyman.data.remote.dtos

data class TravelServiceSearchEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Search>
) {
    data class Search(
        val adults: Int,
        val check_in_date: String,
        val check_out_date: String,
        val children: Int,
        val destination: String,
        val infants: Int,
        val pets: Int,
        val teens: Int
    )
}