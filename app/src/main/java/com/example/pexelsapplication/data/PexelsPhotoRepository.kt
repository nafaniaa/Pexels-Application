package com.example.pexelsapplication.data

import com.example.pexelsapplication.network.PexelsApi
import com.example.pexelsapplication.data.PexelsPhotoEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext


interface PhotosRepository{
    suspend fun getPhotos(query: String, perPage: Int, page: Int) : List<PexelsPhoto>
    suspend fun getCuratedPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto>

     fun getAllPhotos(): Flow<List<PexelsPhotoEntity>>

    fun getLikedPhotos(): Flow<List<PexelsPhotoEntity>>

    fun getCuratedPhotos(): Flow<List<PexelsPhotoEntity>>

    suspend fun handlePhotos(photos: List<PexelsPhotoEntity>)

}

class PexelsPhotoRepository(private val pexelsApi: PexelsApi, private val pexelsPhotoDao: PexelsPhotoDao) : PhotosRepository {

    override suspend fun getPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto> {
        return pexelsApi.searchPhotos(query, perPage, page).photos
    }

    override suspend fun getCuratedPhotos(query: String, perPage: Int, page: Int): List<PexelsPhoto> {
        return pexelsApi.getCuratedPhotos(perPage, page).photos
    }


    override fun getAllPhotos(): Flow<List<PexelsPhotoEntity>> {
        return pexelsPhotoDao.getAll()
    }


    override fun getLikedPhotos(): Flow<List<PexelsPhotoEntity>> {
        return pexelsPhotoDao.getAllLiked()
    }


    override fun getCuratedPhotos(): Flow<List<PexelsPhotoEntity>> {
        return pexelsPhotoDao.getCurated()
    }


    override suspend fun handlePhotos(photos: List<PexelsPhotoEntity>) {
        withContext(Dispatchers.IO) {
            pexelsPhotoDao.insertAll(photos)
        }
    }
}