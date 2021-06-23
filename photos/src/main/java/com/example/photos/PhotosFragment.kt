package com.example.photos

import android.os.Bundle
import android.view.View
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.photos.databinding.FragmentPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosFragment : BaseFragment(R.layout.fragment_photos) {

    private val binding: FragmentPhotosBinding by viewLifecycleScoped(FragmentPhotosBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}