package com.example.photos.data.response

import androidx.annotation.Keep

@Keep
data class ProfileImage(
    val large: String,
    val medium: String,
    val small: String
)