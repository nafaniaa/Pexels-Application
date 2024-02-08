package com.example.pexelsapplication.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "photos")
data class PexelsPhotoEntity(
    @PrimaryKey
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val tiny: String,
    val small: String,
    val medium: String,
    val large: String,
    val original: String,
    var isLiked: Boolean = false,
    @ColumnInfo(name = "query_param")
    var queryParam: String? = null,
    @ColumnInfo(name = "is_curated")
    var isCurated: Boolean = false
) {
    companion object {
        fun empty(): PexelsPhotoEntity {
            return PexelsPhotoEntity(
                id = 0,
                width = 0,
                height = 0,
                url = "",
                photographer = "",
                tiny = "",
                small = "",
                medium = "",
                large = "",
                original = "",
                isLiked = false,
                queryParam = "",
                isCurated = false
            )
        }
    }

    fun asPhoto() = PexelsPhoto(
        id,
        width,
        height,
        url,
        photographer,
        mapOf(
            Pair("tiny", tiny),
            Pair("small", small),
            Pair("medium", medium),
            Pair("large", large),
            Pair("original", original)
        ),
        isLiked,
        queryParam,
        isCurated
    )
}
