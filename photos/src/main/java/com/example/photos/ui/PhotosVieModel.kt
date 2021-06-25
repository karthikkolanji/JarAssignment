package com.example.photos.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.base.di.IoDispatcher
import com.example.base.utils.ApiError
import com.example.base.utils.State
import com.example.photos.domain.GetPhotosUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class PhotosVieModel @Inject constructor(
    private val getPhotosUseCase: GetPhotosUseCase,
    @IoDispatcher private val ioDispatcher: Dispatchers
) : ViewModel() {

    fun getPhotos()  = liveData {
        emit(State.LoadingState)
        try {
            emit(getPhotosUseCase.getPhotos())
        }
        catch (e:Exception){
            e.printStackTrace()
            emit(ApiError.resolveError(e))
        }
    }
}