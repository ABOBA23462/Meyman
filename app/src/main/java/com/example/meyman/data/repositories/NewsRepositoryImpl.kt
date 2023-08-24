package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.NewsApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.NewsRepository
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val newsApiService: NewsApiService
) : BaseRepository(), NewsRepository {

    override suspend fun fetchNews() = doRequest {
        newsApiService.fetchNewsDto().results.map{
            it.toDomain()
        }
    }
}