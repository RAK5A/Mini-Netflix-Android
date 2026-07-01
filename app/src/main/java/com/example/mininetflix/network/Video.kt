package com.example.mininetflix.network

data class Video(
    val id: Int,
    val key: String,
    val name: String,      // e.g. "Official Trailer"
    val site: String,      // we filter for "YouTube"
    val type: String,      // we filter for "Trailer"
    val official: Boolean
)
