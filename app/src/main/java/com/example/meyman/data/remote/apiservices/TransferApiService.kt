package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.TransferDto
import com.example.meyman.data.remote.dtos.TransferItemDto
import retrofit2.http.GET

interface TransferApiService {

    @GET("api/travel_transfer/")
    fun fetchTransfer(): TransferDto<TransferItemDto>
}