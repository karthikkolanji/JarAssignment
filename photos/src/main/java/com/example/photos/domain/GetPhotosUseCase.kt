package com.example.photos.domain

import com.example.photos.data.PhotosRepository
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {

    suspend fun getPhotos() = photosRepository.getPhotos()
}