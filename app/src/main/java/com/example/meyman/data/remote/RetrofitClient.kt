package com.example.meyman.data.remote

import com.example.meyman.data.remote.apiservices.ApartmentApiServer
import com.example.meyman.data.remote.apiservices.GuestHousesApiServer
import com.example.meyman.data.remote.apiservices.HostelsApiServer
import com.example.meyman.data.remote.apiservices.HotelApiServer
import com.example.meyman.data.remote.apiservices.NewsApiServer
import com.example.meyman.data.remote.apiservices.ReviewApiServer
import com.example.meyman.data.remote.apiservices.SanatoriumsApiServer
import com.example.meyman.data.remote.apiservices.SearchApiServer
import com.example.meyman.data.remote.apiservices.TransferApiServer
import com.example.meyman.data.remote.apiservices.UsernameApiServer
import com.example.meyman.data.remote.apiservices.UsersApiServer
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl("http://127.0.0.1:8000/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    fun provideApartmentApiService(): ApartmentApiServer {
        return retrofitClient.create(ApartmentApiServer::class.java)
    }

    fun provideGuestHousesApiServer(): GuestHousesApiServer {
        return retrofitClient.create(GuestHousesApiServer::class.java)
    }

    fun provideHostelsApiServer(): HostelsApiServer {
        return retrofitClient.create(HostelsApiServer::class.java)
    }

    fun provideHotelApiServer(): HotelApiServer {
        return retrofitClient.create(HotelApiServer::class.java)
    }

    fun provideNewsApiServer(): NewsApiServer {
        return retrofitClient.create(NewsApiServer::class.java)
    }

    fun provideReviewApiServer(): ReviewApiServer {
        return retrofitClient.create(ReviewApiServer::class.java)
    }

    fun provideSanatoriumsApiServer(): SanatoriumsApiServer {
        return retrofitClient.create(SanatoriumsApiServer::class.java)
    }

    fun provideSearchApiServer(): SearchApiServer {
        return retrofitClient.create(SearchApiServer::class.java)
    }

    fun provideTransferApiServer(): TransferApiServer {
        return retrofitClient.create(TransferApiServer::class.java)
    }

    fun provideUsernameApiServer(): UsernameApiServer {
        return retrofitClient.create(UsernameApiServer::class.java)
    }

    fun provideUsersApiServer(): UsersApiServer {
        return retrofitClient.create(UsersApiServer::class.java)
    }
}