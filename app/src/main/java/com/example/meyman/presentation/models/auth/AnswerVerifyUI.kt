package com.example.meyman.presentation.models.auth

import com.example.meyman.domain.utils.models.AnswerVerifyDomain
import com.google.gson.annotations.SerializedName

data class AnswerVerifyUI(
    @SerializedName("verify_code")
    val verifyCode: String,
    @SerializedName("email")
    val email: String
)

fun AnswerVerifyDomain.toUI() = AnswerVerifyUI(
    verifyCode, email
)