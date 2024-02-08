package com.example.pexelsapplication.network

import com.example.pexelsapplication.data.PexelsPhoto

data class PexelsResponse(
    val photos: List<PexelsPhoto>
)