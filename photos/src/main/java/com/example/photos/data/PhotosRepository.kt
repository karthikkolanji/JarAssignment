package com.example.photos.data

import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PhotosRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getPhotos()=apiService.getPhotos(CLIENT_KEY)

    companion object{
        const val CLIENT_KEY="zTNIUoNt8q6NRP9e3yV61qY0UUQd0X_32NylyN9JRcw"
    }
}