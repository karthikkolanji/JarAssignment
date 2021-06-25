package com.example.photos.domain

import com.example.photos.data.PhotosRepository
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photosRepository: PhotosRepository
) {

    suspend fun getPhotos() = photosRepository.getPhotos()
}