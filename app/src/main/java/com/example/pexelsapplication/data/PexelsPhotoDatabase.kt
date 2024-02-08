package com.example.pexelsapplication.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [PexelsPhotoEntity::class],
    version = 6
)
abstract class PexelsPhotoDatabase : RoomDatabase() {
    abstract fun pexelsPhotoDao(): PexelsPhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PexelsPhotoDatabase? = null

        fun instance(context: Context): PexelsPhotoDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PexelsPhotoDatabase::class.java,
                    "pexels_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()

                INSTANCE = instance
                instance
            }
        }
    }
}
