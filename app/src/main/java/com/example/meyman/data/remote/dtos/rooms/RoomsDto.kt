package com.example.meyman.data.remote.dtos.rooms

import com.squareup.moshi.Json

data class RoomsDto<T>(@Json(name = "next")
                    val next: Int = 0,
                       @Json(name = "previous")
                    val previous: Int = 0,
                       @Json(name = "count")
                    val count: Int = 0,
                       @Json(name = "results")
                    val results: List<T>)