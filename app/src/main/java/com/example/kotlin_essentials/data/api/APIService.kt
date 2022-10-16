package com.example.kotlin_essentials.data.api

import com.example.kotlin_essentials.data.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface APIService {

    @GET("shows")
    suspend fun getAllShows() : Response<TvShowResponse>
}