package com.sevenrocks.timelibrary.date.dateWidget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.sevenrocks.timelibrary.R;


/**
 * TextView with circular colored background
 * @author JJamet
 */
public class TextCircularIndicatorView extends AppCompatTextView {

    private int mCircleColor = Color.BLUE;
    private Paint mCirclePaint = new Paint();

    public TextCircularIndicatorView(Context context) {
        this(context, null, 0);
    }

    public TextCircularIndicatorView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextCircularIndicatorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    /**
     * Initialize constructor
     */
    private void init(AttributeSet attrs) {

        if(attrs != null) {
            TypedArray circularIndicatorTypedArray = getContext().obtainStyledAttributes(attrs, R.styleable.TextCircularIndicatorView);
            setCircleColor(circularIndicatorTypedArray.getColor(R.styleable.TextCircularIndicatorView_colorCircleIndicator, mCircleColor));
            circularIndicatorTypedArray.recycle();
        }

        mCirclePaint.setFakeBoldText(true);
        mCirclePaint.setAntiAlias(true);
        mCirclePaint.setColor(mCircleColor);
        mCirclePaint.setTextAlign(Paint.Align.CENTER);
        mCirclePaint.setStyle(Paint.Style.FILL);
    }

    @SuppressLint("GetContentDescriptionOverride")
    @Override
    public CharSequence getContentDescription() {
        return getText();
    }

    @Override
    public void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2;
        canvas.drawCircle(width / 2, height / 2, radius, mCirclePaint);
        super.onDraw(canvas);
    }

    /**
     * Get color of background circle
     */
    public int getCircleColor() {
        return mCircleColor;
    }

    /**
     * Set color of background circle
     */
    public void setCircleColor(@ColorInt int color) {
        this.mCircleColor = color;
    }

}