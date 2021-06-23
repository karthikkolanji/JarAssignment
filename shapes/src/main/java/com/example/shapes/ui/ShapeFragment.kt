package com.example.shapes.ui

import android.os.Bundle
import android.view.View
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.shapes.R
import com.example.shapes.databinding.FragmentShapeBinding
import com.example.shapes.view.RandomCircles


class ShapeFragment : BaseFragment(R.layout.fragment_shape) {

    private val binding: FragmentShapeBinding by viewLifecycleScoped(
        FragmentShapeBinding::bind)

    var circleList= mutableListOf<View>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       binding.apply {
           btAddCircle.setOnClickListener {
               val circle=RandomCircles(requireContext())
               circleContainer.addView(circle)
               circleList.add(circle)
           }
       }

        binding.btUndo.setOnClickListener {
            binding.circleContainer.removeView(circleList[circleList.size-1])
        }
    }
}