package com.example.pexelsapplication

import android.app.Application
import com.example.pexelsapplication.data.PexelsPhotoDao
import com.example.pexelsapplication.data.PexelsPhotoDatabase
import com.example.pexelsapplication.network.PexelsApiClient
import com.example.pexelsapplication.network.PexelsAppContainer

class PexelsApplication : Application() {
    lateinit var container: PexelsAppContainer

    override fun onCreate() {
        super.onCreate()
        container = PexelsAppContainerImpl(this)
    }
}
