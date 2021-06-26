package com.example.photos.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.base.extensions.gone
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.extensions.visible
import com.example.base.utils.State
import com.example.photos.R
import com.example.photos.data.response.Photos
import com.example.photos.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class PhotosFragment : Fragment(R.layout.fragment_photos) {

    private val binding: FragmentPhotosBinding by viewLifecycleScoped(FragmentPhotosBinding::bind)
    private val viewModel: PhotosVieModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initData()
    }

    private fun initData() {
        lifecycleScope.launch {
            viewModel.getPhotos().observe(this@PhotosFragment, Observer {

                when (it) {
                    is State.LoadingState -> {
                        showLoading()
                        Timber.d("PhotoState LoadingState")
                    }
                    is State.Success<*> -> {
                        showData(it.data as Photos)
                        Timber.d("PhotoState Success ${it.data}")

                    }
                    is State.ErrorState -> {
                        Timber.d("PhotoState ErrorState ${it.exception}")
                    }
                }

            })
        }
    }

    private fun showLoading() {
        binding.apply {
            viewLoading.rootLoading.visible()
            rvPhotos.gone()
        }
    }

    private fun showData(photos: Photos) {
        viewModel.photosAdapter.setPhotos(photos)
        binding.apply {
            viewLoading.rootLoading.gone()
            rvPhotos.adapter=viewModel.photosAdapter
            rvPhotos.visible()
        }


    }
}