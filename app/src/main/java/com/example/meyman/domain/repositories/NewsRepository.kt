package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.NewsItemModel
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun fetchNews(): Flow<Either<String, List<NewsItemModel>>>

}