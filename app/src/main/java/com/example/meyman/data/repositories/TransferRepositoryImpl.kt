package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.TransferApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.TransferRepository
import javax.inject.Inject

class TransferRepositoryImpl @Inject constructor(
    private val transferApiService: TransferApiService
) : BaseRepository(), TransferRepository {

    override suspend fun fetchTransfer() = doRequest {
        transferApiService.fetchTransfer().results.map{
            it.toDomain()
        }
    }
}