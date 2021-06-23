package com.example.shapes.ui

import android.os.Bundle
import android.view.View
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.jarassignment.R
import com.example.jarassignment.databinding.FragmentShapeBinding


class ShapeFragment : BaseFragment(R.layout.fragment_shape) {

    private val binding: FragmentShapeBinding by viewLifecycleScoped(FragmentShapeBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        binding.btAddCircle.setOnClickListener {
//            val circle = RandomCircles(requireContext())
//            binding.circleContainer.addView(circle)
//
//        }
    }
}