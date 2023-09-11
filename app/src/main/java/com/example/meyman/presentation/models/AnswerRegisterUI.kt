package com.example.meyman.presentation.models

import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.google.gson.annotations.SerializedName

data class AnswerRegisterUI(@SerializedName("user_type")
                            val userType: String = "",
                            @SerializedName("email")
                            val email: String = "",
                            @SerializedName("username")
                            val username: String = "")

fun AnswerRegisterModel.toUI() = AnswerRegisterUI(
    userType, email, username
)