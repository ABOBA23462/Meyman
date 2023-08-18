package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.ApartmentDto
import com.example.meyman.data.remote.dtos2.ResultDto
import retrofit2.http.GET

interface ApartmentApiService {

    @GET("travel/apartment/")
    fun fetchApartment(): ApartmentDto<ResultDto>
}