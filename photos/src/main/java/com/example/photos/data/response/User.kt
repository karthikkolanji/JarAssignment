package com.example.photos.data.response

import androidx.annotation.Keep

@Keep
data class User(
    val accepted_tos: Boolean,
    val bio: String,
    val first_name: String,
    val for_hire: Boolean,
    val id: String,
    val instagram_username: Any,
    val last_name: String="",
    val links: LinksXX,
    val location: String? = null,
    val name: String,
    val portfolio_url: String,
    val profile_image: ProfileImageX,
    val total_collections: Int,
    val total_likes: Int,
    val total_photos: Int,
    val twitter_username: String,
    val updated_at: String,
    val username: String
)