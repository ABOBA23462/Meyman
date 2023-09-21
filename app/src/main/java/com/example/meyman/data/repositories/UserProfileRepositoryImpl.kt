package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.UserProfileApiService
import com.example.meyman.data.remote.dtos.profile.toDomain
import com.example.meyman.domain.repositories.UserProfileRepository
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody
import okhttp3.RequestBody
import javax.inject.Inject

class UserProfileRepositoryImpl @Inject constructor(
    private val service: UserProfileApiService
) : BaseRepository(), UserProfileRepository {

    override fun fetchUserProfile(token: String) = doRequest {
        service.fetchUserProfile(token).toDomain()
    }

    override fun fetchChangeUserProfile(
        token: String,
        image: MultipartBody.Part?,
        username: RequestBody,
        phoneNumber: RequestBody
    ) = doRequest {
        service.fetchChangeUserProfile(token,
            image,
            username, phoneNumber).toDomain()
    }
}