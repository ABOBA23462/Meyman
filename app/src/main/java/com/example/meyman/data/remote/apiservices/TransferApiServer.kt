package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.TransferDto
import com.example.meyman.data.remote.dtos.TransferItemDto
import retrofit2.Response
import retrofit2.http.GET

interface TransferApiServer {

    @GET("api/travel_transfer/")
    fun fetchTransfer(): Response<TransferDto>

    @GET("api/travel_transfer/")
    fun fetchTransferItemDto(): Response<TransferItemDto>
}