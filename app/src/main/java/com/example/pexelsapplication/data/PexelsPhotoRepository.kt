package com.example.pexelsapplication.data

import com.example.pexelsapplication.network.PexelsApi
import com.example.pexelsapplication.data.PexelsPhotoEntity


interface PhotosRepository{
    suspend fun getPhotos(query: String, perPage: Int, page: Int) : List<PexelsPhoto>
    suspend fun getCuratedPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto>
}

class PexelsPhotoRepository(
    private val pexelsApi: PexelsApi
) : PhotosRepository {

    override suspend fun getPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto> =
        pexelsApi.searchPhotos(query, perPage, page).photos

    override suspend fun getCuratedPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto> =
        pexelsApi.getCuratedPhotos(perPage, page).photos
}