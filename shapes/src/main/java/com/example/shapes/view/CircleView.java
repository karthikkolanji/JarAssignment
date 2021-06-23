package com.example.shapes.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class CircleView extends View {

    private static final String COLOR_HEX = "#E74300";
    private final Paint drawPaint;
    private float size;
    float x = 0F;
    float y = 0F;
    float radius = 0F;

    public CircleView(final Context context) {
        super(context);
        drawPaint = new Paint();
        drawPaint.setColor(Color.parseColor(COLOR_HEX));
        drawPaint.setAntiAlias(true);

    }

    @Override
    protected void onDraw(final Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(100, 100, 50, drawPaint);
    }

    Random random = new Random();

    void generateRandom() {
        int minRadius = 100;
        int w = getWidth();
        int h = getHeight();
        this.x = random.nextInt(w);
        this.y = random.nextInt(h);
        this.radius = minRadius + random.nextInt(100);
    }

    public void addCircle() {
       // generateRandom();
        //invalidate();
    }

}