package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.auth.token.AnswerAccessTokenDto
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface TokenApiService {

    @POST("api/users/tokens/refresh_access_token/")
    suspend fun fetchToken(
        @Header("Authorization") token: String,
        @Body refreshTokenDto: RefreshTokenDto): AnswerAccessTokenDto
}