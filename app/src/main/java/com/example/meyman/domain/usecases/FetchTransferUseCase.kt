package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.TransferRepository
import javax.inject.Inject

class FetchTransferUseCase @Inject constructor(
    private  val transferRepository: TransferRepository
) {
    suspend operator fun invoke() = transferRepository.fetchTransfer()
}