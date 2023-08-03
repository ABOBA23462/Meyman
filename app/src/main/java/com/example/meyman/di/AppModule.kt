package com.example.meyman.di

import com.example.meyman.data.remote.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    val retrofitClient = RetrofitClient()

    @Singleton
    @Provides
    fun provideApartmentApiService() = retrofitClient.provideApartmentApiService()

    @Singleton
    @Provides
    fun provideGuestHousesApiService() = retrofitClient.provideGuestHousesApiServer()

    @Singleton
    @Provides
    fun provideHostelsApiService() = retrofitClient.provideHostelsApiServer()

    @Singleton
    @Provides
    fun provideHotelApiService() = retrofitClient.provideHotelApiServer()

    @Singleton
    @Provides
    fun provideNewsApiService() = retrofitClient.provideNewsApiServer()

    @Singleton
    @Provides
    fun provideReviewApiService() = retrofitClient.provideReviewApiServer()

    @Singleton
    @Provides
    fun provideSanatoriumsApiService() = retrofitClient.provideSanatoriumsApiServer()

    @Singleton
    @Provides
    fun provideSearchApiService() = retrofitClient.provideSearchApiServer()

    @Singleton
    @Provides
    fun provideTransferApiService() = retrofitClient.provideTransferApiServer()

    @Singleton
    @Provides
    fun provideUsersApiService() = retrofitClient.provideUsersApiServer()

    @Singleton
    @Provides
    fun provideUsernameApiService() = retrofitClient.provideUsernameApiServer()
}