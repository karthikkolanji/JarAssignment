package com.example.shapes.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RandomCircles extends View {

    private static final String TAG = "RandomCircles";
    public int height;
    public int width;
    Context context;
    private Paint mPaint;

    private Data data = null;

    private static final int MAX_SIZE = 200;
    private List<Data> previousDataList = new ArrayList<>();

    public RandomCircles(Context c) {
        super(c);
        context = c;
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
//        this.width = w;
//        this.height = h;
        generateCircle(w, h);
        Log.d(TAG, "onSizeChanged: ");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: ");

        if (!checkCollision(data.x, data.y, data.size)) {
           // previousDataList.add(new Data(data.x, data.y, data.size));

            canvas.drawCircle(data.x, data.y, data.size, mPaint);
        }


//        for (Data data : dataList) {
//            int size = data.size;
//            mPaint.setAlpha(255 - size);
//
//            // checking collision
//
//
//
//            canvas.drawCircle(data.x, data.y, data.size, mPaint);
//        }


//        int w = getWidth();
//        int h = getHeight();
//
//        int pl = getPaddingLeft();
//        int pr = getPaddingRight();
//        int pt = getPaddingTop();
//        int pb = getPaddingBottom();
//
//        int usableWidth = w - (pl + pr);
//        int usableHeight = h - (pt + pb);
//
//        int radius = Math.min(usableWidth, usableHeight) / 2;
//        int cx = pl + (usableWidth / 2);
//        int cy = pt + (usableHeight / 2);
//
//        canvas.drawCircle(cx, cy, radius, mPaint);
    }

    private void generateCircle(int width, int height) {
        Log.d(TAG, "generateCircle: ");

        float _x = (int) (Math.random() * width);
        float _y = (int) (Math.random() * height);
        int size = (int) (Math.random() * MAX_SIZE);
        data = new Data(_x, _y, size);
    }


    class Data {
        public float x;
        public float y;
        public int size;

        public Data(float x, float y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }
    }

    boolean checkCollision(float x, float y, int radius) {
        boolean collided = false;
        for (Data previousCircle : previousDataList) {

            float distanceSqrt = (previousCircle.x - x) * (previousCircle.x - x) + (previousCircle.y - y) * (previousCircle.x - x);
            int radSumSq = (previousCircle.size + radius) * (previousCircle.size + radius);
            if (distanceSqrt == radSumSq)
                collided = true;
            else if (distanceSqrt > radSumSq)
                collided = false;
            else
                collided = true;
        }
        Log.d(TAG, "checkCollision: =" + collided);
        return collided;
    }

}