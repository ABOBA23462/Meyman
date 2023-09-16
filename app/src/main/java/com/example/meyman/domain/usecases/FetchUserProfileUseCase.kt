package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.UserProfileRepository
import javax.inject.Inject

class FetchUserProfileUseCase  @Inject constructor(
    private val userProfileRepository: UserProfileRepository
){
    suspend operator fun invoke(token: String) = userProfileRepository.fetchUserProfile(token)
}