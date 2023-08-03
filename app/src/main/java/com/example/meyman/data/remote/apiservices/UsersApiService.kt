package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.UserDto
import com.example.meyman.data.remote.dtos.UsernameDto
import retrofit2.http.GET

interface UsersApiService {

    @GET("users/users/")
    fun fetchUsername(): UserDto<UsernameDto>
}