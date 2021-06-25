package com.example.photos.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.base.utils.State
import com.example.base.utils.Status
import com.example.photos.R
import com.example.photos.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

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
                        Timber.d("LoadingState")
                    }
                    is State.Success<*> -> {
                        Timber.d("Success ${it.data}")

                    }
                    is State.ErrorState -> {
                        Timber.d("ErrorState ${it.exception}")
                    }
                }

            })
        }
    }
}