package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.SearchItemModel
import com.example.meyman.domain.utils.models.TravelItemModel
import kotlinx.coroutines.flow.Flow

interface SearchRepository {

    suspend fun fetchSearch(): Flow<Either<String, List<SearchItemModel>>>

}