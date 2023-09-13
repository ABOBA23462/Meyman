package com.example.meyman.presentation.models

import com.example.meyman.domain.utils.models.VerifyDomain
import com.google.gson.annotations.SerializedName

data class VerifyUI(
    @SerializedName("verify_code")
    val verifyCode: String,
    @SerializedName("email")
    val email: String
)

fun VerifyDomain.toUI() = VerifyUI(
    verifyCode, email
)