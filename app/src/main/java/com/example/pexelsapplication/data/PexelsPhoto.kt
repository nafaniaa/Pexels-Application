package com.example.pexelsapplication.data

import com.example.pexelsapplication.data.enums.PexelsSize

data class PexelsPhoto(
    val id: Int,
    val width: Int,
    val height: Int,
    val url: String,
    val photographer: String,
    val src: Map<String, String>,
    var isLiked: Boolean = false,
    var queryParam: String? = null,
    var isCurated: Boolean = false
) {



    fun asEntity() = PexelsPhotoEntity(
        id,
        width,
        height,
        url,
        photographer,
        src[PexelsSize.TINY.sizeName] ?: "",
        src[PexelsSize.SMALL.sizeName] ?: "",
        src[PexelsSize.MEDIUM.sizeName] ?: "",
        src[PexelsSize.LARGE.sizeName] ?: "",
        src[PexelsSize.ORIGINAL.sizeName] ?: "",
        isLiked,
        queryParam,
        isCurated
    )
}
