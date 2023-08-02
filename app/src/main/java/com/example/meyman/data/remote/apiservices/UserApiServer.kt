package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.UserDto
import com.example.meyman.data.remote.dtos.UsernameDto
import retrofit2.http.GET

interface UserApiServer {

    @GET("api/users/users/")
    fun fetchUsername(): UserDto<UsernameDto>
}