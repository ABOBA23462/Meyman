package com.example.meyman.di

import com.example.meyman.data.repositories.ApartmentRepositoryImpl
import com.example.meyman.data.repositories.ChooseRoomRepositoryImpl
import com.example.meyman.data.repositories.GuestHousesRepositoryImpl
import com.example.meyman.data.repositories.HostelsRepositoryImpl
import com.example.meyman.data.repositories.HotelRepositoryImpl
import com.example.meyman.data.repositories.NewsRepositoryImpl
import com.example.meyman.data.repositories.ReviewRepositoryImpl
import com.example.meyman.data.repositories.SanatoriumsRepositoryImpl
import com.example.meyman.data.repositories.SearchRepositoryImpl
import com.example.meyman.data.repositories.TransferRepositoryImpl
import com.example.meyman.domain.repositories.ApartmentRepository
import com.example.meyman.domain.repositories.ChooseRoomRepository
import com.example.meyman.domain.repositories.GuestHousesRepository
import com.example.meyman.domain.repositories.HostelRepository
import com.example.meyman.domain.repositories.HotelRepository
import com.example.meyman.domain.repositories.NewsRepository
import com.example.meyman.domain.repositories.ReviewRepository
import com.example.meyman.domain.repositories.SanatoriumsRepository
import com.example.meyman.domain.repositories.SearchRepository
import com.example.meyman.domain.repositories.TransferRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoriesModule {

    @Binds
    fun provideApartmentRepository(repositoryImpl: ApartmentRepositoryImpl): ApartmentRepository

    @Binds
    fun provideGuestHousesRepository(repositoryImpl: GuestHousesRepositoryImpl): GuestHousesRepository

    @Binds
    fun provideHostelsRepository(repositoryImpl: HostelsRepositoryImpl): HostelRepository

    @Binds
    fun provideHotelRepository(repositoryImpl: HotelRepositoryImpl): HotelRepository

    @Binds
    fun provideNewsRepository(repositoryImpl: NewsRepositoryImpl): NewsRepository

    @Binds
    fun provideReviewRepository(repositoryImpl: ReviewRepositoryImpl): ReviewRepository

    @Binds
    fun provideSanatoriumsRepository(repositoryImpl: SanatoriumsRepositoryImpl): SanatoriumsRepository

    @Binds
    fun provideSearchRepository(repositoryImpl: SearchRepositoryImpl): SearchRepository

    @Binds
    fun provideTransferRepository(repositoryImpl: TransferRepositoryImpl): TransferRepository

    @Binds
    fun provideChooseRepository(repositoryImpl: ChooseRoomRepositoryImpl): ChooseRoomRepository
}