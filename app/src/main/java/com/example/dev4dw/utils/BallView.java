package com.example.dev4dw.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class BallView extends View {
    Paint mPain;
    int mX, mY;
    int mColor;

    public BallView(Context context) {
        super(context);
        init(context, null);
    }

    public BallView(Context context, int x, int y, int color) {
        super(context);
        init(context, null);
        mX = x;
        mY = y;
        mColor = color;
    }

    public BallView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);

    }

    public BallView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        mPain = new Paint();
        mPain.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPain.setColor(Color.RED);
        mPain.setStyle(Paint.Style.FILL);
        canvas.drawCircle(mX, mY, 20, mPain);
    }
}
