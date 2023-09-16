package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.profile.UserProfileDto
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.profile.UserProfileModel
import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import kotlinx.coroutines.flow.Flow

interface UserProfileRepository {

    suspend fun fetchUserProfile(token: String): Flow<Either<String, UserProfileModel?>>
}