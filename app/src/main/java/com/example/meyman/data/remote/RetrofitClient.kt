package com.example.meyman.data.remote

import com.example.meyman.core.Constant
import com.example.meyman.data.remote.apiservices.ApartmentApiService
import com.example.meyman.data.remote.apiservices.GuestHousesApiService
import com.example.meyman.data.remote.apiservices.HostelsApiService
import com.example.meyman.data.remote.apiservices.HotelApiService
import com.example.meyman.data.remote.apiservices.NewsApiService
import com.example.meyman.data.remote.apiservices.ReviewApiService
import com.example.meyman.data.remote.apiservices.SanatoriumsApiService
import com.example.meyman.data.remote.apiservices.SearchApiService
import com.example.meyman.data.remote.apiservices.TransferApiService
import com.example.meyman.data.remote.apiservices.UsersApiService
import com.example.meyman.data.remote.apiservices.UsernameApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    val retrofitClient = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .client(okHttpClient)
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)


    fun provideApartmentApiService(): ApartmentApiService {
        return retrofitClient.create(ApartmentApiService::class.java)
    }

    fun provideGuestHousesApiServer(): GuestHousesApiService {
        return retrofitClient.create(GuestHousesApiService::class.java)
     }

    fun provideHostelsApiServer(): HostelsApiService {
        return retrofitClient.create(HostelsApiService::class.java)
    }

    fun provideHotelApiServer(): HotelApiService {
        return retrofitClient.create(HotelApiService::class.java)
    }

    fun provideNewsApiServer(): NewsApiService {
        return retrofitClient.create(NewsApiService::class.java)
    }

    fun provideReviewApiServer(): ReviewApiService {
        return retrofitClient.create(ReviewApiService::class.java)
    }

    fun provideSanatoriumsApiServer(): SanatoriumsApiService {
        return retrofitClient.create(SanatoriumsApiService::class.java)
    }

    fun provideSearchApiServer(): SearchApiService {
        return retrofitClient.create(SearchApiService::class.java)
    }

    fun provideTransferApiServer(): TransferApiService {
        return retrofitClient.create(TransferApiService::class.java)
    }

    fun provideUsernameApiServer(): UsernameApiService {
        return retrofitClient.create(UsernameApiService::class.java)
    }

    fun provideUsersApiServer(): UsersApiService {
        return retrofitClient.create(UsersApiService::class.java)
    }
}