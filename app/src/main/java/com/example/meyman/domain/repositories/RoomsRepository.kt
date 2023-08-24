package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.rooms.ResultsItemModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow

interface RoomsRepository {

    suspend fun fetchRooms(): Flow<Either<String, List<ResultsItemModel>>>

    fun fetchDetailRooms(id: Int): Flow<Resource<ResultsItemModel>>
}