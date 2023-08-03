package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.HostelRepository
import javax.inject.Inject

class FetchHostelUseCase @Inject constructor(
    private  val hostelRepository: HostelRepository
) {
    suspend operator fun invoke() = hostelRepository.fetchHostel()
}