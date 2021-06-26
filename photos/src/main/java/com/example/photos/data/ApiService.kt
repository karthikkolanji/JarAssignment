package com.example.photos.data

import com.example.photos.data.response.Photos
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("photos/?")
    suspend fun getPhotos(@Query("client_id") clientId: String): Photos
}