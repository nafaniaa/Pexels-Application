package com.example.pexelsapplication

import android.app.Application
import com.example.pexelsapplication.data.PexelsPhotoDatabase
import com.example.pexelsapplication.data.PexelsPhotoRepository
import com.example.pexelsapplication.data.PhotosRepository
import com.example.pexelsapplication.network.PexelsApiClient
import com.example.pexelsapplication.network.PexelsAppContainer

class PexelsAppContainerImpl(application: Application) : PexelsAppContainer {
    // Создаем экземпляр базы данных и ее DAO
    private val database = PexelsPhotoDatabase.instance(application)
    private val pexelsPhotoDao = database.pexelsPhotoDao()

    // Создаем экземпляр клиента API и передаем ему DAO
    private val pexelsApiClient = PexelsApiClient(application, pexelsPhotoDao)

    // Создаем репозиторий и передаем ему клиент API и DAO
    override val photosRepository: PhotosRepository by lazy {
        PexelsPhotoRepository(pexelsApiClient.pexelsApi, pexelsPhotoDao)
    }
}