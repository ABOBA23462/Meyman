package com.example.meyman.data.remote.apiservices

import retrofit2.http.Body
import retrofit2.http.POST

interface ForgotPasswordApiService {

    @POST("api/users/reset-password-email/")
    suspend fun fetchResetPasswordEmail( )
}