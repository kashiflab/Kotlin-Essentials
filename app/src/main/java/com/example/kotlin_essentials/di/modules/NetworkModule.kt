package com.example.kotlin_essentials.di.modules

import com.example.kotlin_essentials.data.api.APIService
import com.example.kotlin_essentials.data.utils.Constants
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit():Retrofit{
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesAPIService(retrofit: Retrofit):APIService{
        return retrofit.create(APIService::class.java)
    }
}