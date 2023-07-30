package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.TransferItemDto
import retrofit2.Call
import retrofit2.http.GET

interface TravelServiceTransferApiServer {

    @GET("api/travel_sevice/transfer/")
    fun fetchTravelServiceTransfer(): Call<TransferItemDto>
}