package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.UsernameDto
import retrofit2.Response
import retrofit2.http.GET

interface UsernameApiService {

    @GET("users/users/")
    fun fetchUsername(): Response<UsernameDto>
}