package com.example.photos.data.response

import androidx.annotation.Keep

@Keep
data class Links(
    val download: String,
    val download_location: String,
    val html: String,
    val self: String
)