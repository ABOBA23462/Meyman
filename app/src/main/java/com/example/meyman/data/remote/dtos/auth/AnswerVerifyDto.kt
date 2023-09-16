package com.example.meyman.data.remote.dtos.auth

import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.google.gson.annotations.SerializedName

data class AnswerVerifyDto(
    @SerializedName("verify_code")
    val verifyCode: String,
    @SerializedName("email")
    val email: String
)

fun AnswerVerifyDto.toDomain() = AnswerVerifyDomain(
    verifyCode, email
)