package com.example.meyman.data.remote.dtos.rooms

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json

data class RoomsDto<T>(@SerializedName("next")
                    val next: Int = 0,
                       @SerializedName ("previous")
                    val previous: Int = 0,
                       @SerializedName ("count")
                    val count: Int = 0,
                       @SerializedName ("results")
                    val results: List<T>)