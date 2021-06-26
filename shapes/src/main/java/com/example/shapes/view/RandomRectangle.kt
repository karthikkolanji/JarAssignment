package com.example.shapes.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.Log
import android.view.View
import java.util.*

class RandomRectangle(context: Context) : View(context) {
    private val TAG = "RandomRectangle"
    private var mPaint: Paint? = null

    private var data: Data? = null

    private val MAX_SIZE = 200
    private val previousDataList: List<Data> = ArrayList()

    init {
        mPaint = Paint()
        mPaint?.isAntiAlias = true
        mPaint?.color = Color.BLACK
        mPaint?.style = Paint.Style.FILL
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        generateCircle(w, h)
        Log.d(TAG, "onSizeChanged: ")
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        Log.d(TAG, "onDraw: ")
        if (!checkCollision(data!!.x, data!!.y, data!!.size)) {
            canvas.drawRect(data!!.x, data!!.x, data!!.y, data!!.y, mPaint!!)
        }

    }

    private fun generateCircle(width: Int, height: Int) {
        Log.d(TAG, "generateCircle: ")
        val _x: Float = (Math.random() * width).toFloat()
        val _y: Float = (Math.random() * height).toFloat()
        val size = (Math.random() * MAX_SIZE).toInt()
        data = Data(_x, _y, size)
    }

    fun checkCollision(x: Float, y: Float, radius: Int): Boolean {
        var collided = false
        for (previousCircle in previousDataList) {
            val distanceSqrt =
                (previousCircle.x - x) * (previousCircle.x - x) + (previousCircle.y - y) * (previousCircle.x - x)
            val radSumSq = (previousCircle.size + radius) * (previousCircle.size + radius)
            collided =
                if (distanceSqrt == radSumSq.toFloat()) true else distanceSqrt <= radSumSq
        }
        Log.d(TAG, "checkCollision: =$collided")
        return collided
    }

    internal class Data(var x: Float, var y: Float, var size: Int)


}