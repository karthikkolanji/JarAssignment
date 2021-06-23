package com.example.jarassignment

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.jarassignment.databinding.FragmentOptionsBinding

class OptionsFragment : BaseFragment(R.layout.fragment_options) {

    private val binding: FragmentOptionsBinding by viewLifecycleScoped(FragmentOptionsBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btGenerateShapes.setOnClickListener {
            findNavController(this).navigate(OptionsFragmentDirections.goToShapesFragment())
        }
        binding.btFetchPhotos.setOnClickListener {
        }
    }

}