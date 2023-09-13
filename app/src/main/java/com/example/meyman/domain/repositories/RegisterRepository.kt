package com.example.meyman.domain.repositories

import com.example.meyman.data.remote.dtos.RegisterDto
import com.example.meyman.domain.utils.models.AnswerRegisterModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow

interface RegisterRepository {
     fun fetchRegister(registerDomain: RegisterDto): Flow<Resource<AnswerRegisterModel>>
}