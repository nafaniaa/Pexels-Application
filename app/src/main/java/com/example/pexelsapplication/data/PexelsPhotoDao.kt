package com.example.pexelsapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface PexelsPhotoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(photo: PexelsPhotoEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(photos: List<PexelsPhotoEntity>)

    @Update
    suspend fun update(photo: PexelsPhotoEntity)

    @Delete
    suspend fun delete(photo: PexelsPhotoEntity)

    @Query("select * from photos where id = :id limit 1")
    suspend fun getById(id: Int): PexelsPhotoEntity

    @Query("delete from photos where id = :id")
    suspend fun deleteById(id: Int)

    @Query("select * from photos")
    fun getAll(): Flow<List<PexelsPhotoEntity>>

    @Query("select * from photos where isLiked = 1")
    fun getAllLiked(): Flow<List<PexelsPhotoEntity>>

    @Query("delete from photos where isLiked = 0")
    suspend fun deleteUnliked()

    @Query("select count(*) > 0 from photos")
    suspend fun isEmpty(): Boolean

    @Query("select * from photos where is_curated = 1")
    fun getCurated(): Flow<List<PexelsPhotoEntity>>
}
