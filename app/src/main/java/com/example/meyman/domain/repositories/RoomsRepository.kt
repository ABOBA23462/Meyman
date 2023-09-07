package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import java.util.concurrent.CompletableFuture

interface RoomsRepository {

    suspend fun fetchDetailRooms(id: Int): Flow<Either<String, ResultsRoomsItemModel?>>
}