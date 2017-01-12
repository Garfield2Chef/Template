package com.hpy.cn.zhtemplate.wheel.test;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;

import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.base.Myapplication;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/6.
 */

public class MytestView extends View {
    private Paint mPaint;

    private int mWidth;
    private int mHeight;
    public MytestView(Context context) {
        super(context);
        mPaint = new Paint();//设置一个笔刷大小为3的黄色的笔刷
        mPaint.setColor(Color.YELLOW);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(3);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        mWidth=canvas.getWidth();
        mHeight=canvas.getHeight();
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,180,mPaint);
//        ToastUtils.showShortToast(Myapplication.getInstance(),canvas.getWidth()+"--------"+canvas.getHeight());
//
//        mPaint.setColor(Color.RED);
//        canvas.translate(200,200);
//        canvas.drawCircle(0,0,180,mPaint);
//
//        ToastUtils.showShortToast(Myapplication.getInstance(),canvas.getWidth()+"--------"+canvas.getHeight());
        mPaint.setColor(Color.BLACK);
        canvas.translate(mWidth/2,mHeight/2);

        RectF rectF = new RectF(0,-400,400,0);
        canvas.drawRect(rectF,mPaint);

        mPaint.setColor(Color.YELLOW);
        canvas.scale(0.5f,0.5f);
        canvas.drawRect(rectF,mPaint);
    }
}
