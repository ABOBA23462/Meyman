package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.VerifyDomain
import com.google.gson.annotations.SerializedName

data class VerifyDto(
    @SerializedName("verify_code")
    val verifyCode: String,
    @SerializedName("email")
    val email: String
)

fun VerifyDto.toDomain() = VerifyDomain(
    verifyCode, email
)