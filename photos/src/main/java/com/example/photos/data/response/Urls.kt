package com.example.photos.data.response

import androidx.annotation.Keep

@Keep
data class Urls(
    val full: String,
    val raw: String,
    val regular: String,
    val small: String,
    val thumb: String
)