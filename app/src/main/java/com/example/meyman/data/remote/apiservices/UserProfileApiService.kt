package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.profile.UserProfileDto
import retrofit2.http.GET
import retrofit2.http.Path

interface UserProfileApiService {

    @GET("api/users/profile/{id}/")
    suspend fun fetchUserProfile(
        @Path("id") id: Int
    ) : UserProfileDto
}