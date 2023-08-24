package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.SearchApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.SearchRepository
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val searchApiService: SearchApiService
) : BaseRepository(), SearchRepository {

    override suspend fun fetchSearch() = doRequest {
        searchApiService.fetchServiceSearch().results.map{
            it.toDomain()
        }
    }
}