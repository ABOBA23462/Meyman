package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.UserDto
import com.example.meyman.data.remote.dtos.UserItemDto
import retrofit2.Response
import retrofit2.http.GET

interface UsersApiServer {

    @GET("api/users/users/")
    fun fetchUsername(): Response<UserDto>

    @GET("api/users/users/")
    fun fetchUsernameItemDto(): Response<UserItemDto>
}