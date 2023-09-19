package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.profile.ChangeUserProfileDto
import com.example.meyman.data.remote.dtos.profile.UserProfileDto
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Multipart
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface UserProfileApiService {

    @GET("api/users/profile/{id}/")
    suspend fun fetchUserProfile(
//        @Path("id") id: Int,
        @Header("Authorization") token: String,
    ): ChangeUserProfileDto

    @Multipart
    @PUT("api/users/profile/{id}/")
    suspend fun fetchChangeUserProfile(
        @Header("Authorization") token: String,
        @Part image : MultipartBody.Part?,
        @Part("username") username : RequestBody,
        @Part("phoneNumber") phoneNumber : RequestBody
        ): ChangeUserProfileDto
}