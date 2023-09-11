package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RegisterApiService
import com.example.meyman.domain.repositories.RegisterRepository
import com.example.meyman.domain.utils.models.RegisterDomain
import javax.inject.Inject

class RegisterRepositoryImpl @Inject constructor(
    private val registerApiService: RegisterApiService,
) : BaseRepository(), RegisterRepository {
            override  fun fetchRegister(registerDomain: RegisterDomain) =
        doRequests {
            registerApiService.fetchRegister(registerDomain)
        }
}