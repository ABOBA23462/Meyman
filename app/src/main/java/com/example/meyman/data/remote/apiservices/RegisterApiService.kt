package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.AnswerRegisterDto
import com.example.meyman.domain.utils.models.RegisterDomain
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RegisterApiService {

    @POST("users/signup/")
    fun fetchRegister(@Body registerDomain: RegisterDomain): Response<AnswerRegisterDto>
}