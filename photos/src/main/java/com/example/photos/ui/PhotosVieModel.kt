package com.example.photos.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.base.di.DispatcherProvider
import com.example.base.utils.ApiError
import com.example.base.utils.State
import com.example.photos.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhotosVieModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    private val dispatcherProvider: DispatcherProvider,
    val photosAdapter: PhotosAdapter
) : ViewModel() {

    fun getPhotos() = liveData(dispatcherProvider.io()) {
        emit(State.LoadingState)
        try {
            emit(State.Success(getPhotosUseCase.getPhotos()))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(ApiError.resolveError(e))
        }
    }
}