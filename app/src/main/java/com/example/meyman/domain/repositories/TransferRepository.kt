package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.TransferItemModel
import kotlinx.coroutines.flow.Flow

interface TransferRepository {

    suspend fun fetchTransfer(): Flow<Either<String, List<TransferItemModel>>>

}