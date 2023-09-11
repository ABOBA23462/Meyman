package com.example.meyman.data.remote.dtos

import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.google.gson.annotations.SerializedName

data class AnswerRegisterDto(
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = ""
)

fun AnswerRegisterDto.toDomain() = AnswerRegisterModel(
    userType, email, username
)