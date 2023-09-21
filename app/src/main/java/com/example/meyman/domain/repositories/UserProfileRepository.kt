package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.profile.UserProfileDto
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import com.example.meyman.domain.utils.models.profile.UserProfileModel
import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody

interface UserProfileRepository {

    fun fetchUserProfile(token: String): Flow<Either<String, ChangeUserProfileModel?>>

    fun fetchChangeUserProfile(
        token: String,
        image: MultipartBody.Part? = null,
        username: RequestBody, phoneNumber: RequestBody
    ): Flow<Either<String, ChangeUserProfileModel?>>
}