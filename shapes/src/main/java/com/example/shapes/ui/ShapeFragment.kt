package com.example.shapes.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.base.extensions.disable
import com.example.base.extensions.enable
import com.example.base.extensions.viewLifecycleScoped
import com.example.base.screen.BaseFragment
import com.example.shapes.R
import com.example.shapes.databinding.FragmentShapeBinding
import com.example.shapes.view.RandomCircle
import com.example.shapes.view.RandomRectangle


class ShapeFragment : Fragment(R.layout.fragment_shape) {

    private val binding: FragmentShapeBinding by viewLifecycleScoped(
        FragmentShapeBinding::bind
    )

    var shapeList = mutableListOf<View>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btAddCircle.setOnClickListener {
            addCircle()
        }

        binding.btAddRectangle.setOnClickListener {
            addRectangle()
        }

        binding.btUndo.setOnClickListener {
            removeShape()
        }
    }

    private fun addCircle() {
        val circle = RandomCircle(requireContext())
        binding.circleContainer.addView(circle)
        shapeList.add(circle)
        binding.btUndo.enable()
    }

    private fun addRectangle() {
        val rectangle = RandomRectangle(requireContext())
        binding.circleContainer.addView(rectangle)
        shapeList.add(rectangle)
        binding.btUndo.enable()
    }

    private fun removeShape() {
        var recentShape: View? = null
        if (shapeList.size == 1) {
            recentShape = shapeList[0]
        }
        if (shapeList.isNotEmpty()) {
            recentShape = shapeList[shapeList.size - 1]
        }
        shapeList.remove(recentShape)
        binding.circleContainer.removeView(recentShape)

        if (shapeList.isEmpty()){
            binding.btUndo.disable()
        }
    }
}