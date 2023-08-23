package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.ChooseRoomModel
import kotlinx.coroutines.flow.Flow

interface ChooseRoomRepository {

    suspend fun getChooseRepository(): Flow<Either<String, List<ChooseRoomModel>>>
}