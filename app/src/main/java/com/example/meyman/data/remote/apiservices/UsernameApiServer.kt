package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.UsernameDto
import retrofit2.Response
import retrofit2.http.GET

interface UsernameApiServer {

    @GET("api/users/users/")
    fun fetchUsername(): Response<UsernameDto>
}