package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RegisterApiService
import com.example.meyman.data.remote.dtos.RegisterDto
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.RegisterRepository
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val registerApiService: RegisterApiService,
) : BaseRepository(), RegisterRepository {
            override  fun fetchRegister(registerDomain: RegisterDto) =
        doRequests {
            registerApiService.fetchRegister(registerDomain).toDomain()
        }
}