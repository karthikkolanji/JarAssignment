package com.example.photos.data.response

import androidx.annotation.Keep

@Keep
data class Sponsorship(
    val impression_urls: List<String>,
    val sponsor: Sponsor,
    val tagline: String,
    val tagline_url: String
)