package com.example.pexelsapplication.network

import retrofit2.http.GET
import retrofit2.http.Query

interface PexelsApi {

    @GET("search")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int = 20,
        @Query("page") page: Int = 1
    ): PexelsResponse

    @GET("curated")
    suspend fun getCuratedPhotos(
        @Query("per_page") perPage: Int = 30,
        @Query("page") page: Int = 1
    ): PexelsResponse
}
