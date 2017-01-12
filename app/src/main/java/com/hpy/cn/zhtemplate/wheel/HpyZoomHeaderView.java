package com.hpy.cn.zhtemplate.wheel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.hpy.cn.zhtemplate.R;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/12.
 */

public class HpyZoomHeaderView extends LinearLayout {

    private float mTouchSlop;
    private TextView mCloseText;
    private HpyZoomHeaderViewPager mViewPager;
    private float mFirstY;
    private float iDownY;
    //图片放到最大时候的y
    private float mMaxY;

    public HpyZoomHeaderView(Context context) {
        super(context);
    }

    public HpyZoomHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //getScaledTouchSlop是一个距离，表示滑动的时候，手的移动要大于这个距离才开始移动控件。如果小于这个距离就不触发移动控件，如viewpager就是用这个距离来判断用户是否翻页
        mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public HpyZoomHeaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        mViewPager = (HpyZoomHeaderViewPager) getChildAt(1);
        //子view左上角相对于父view左上角的坐标！！！
        mFirstY = getY();
//        mCloseText = findViewById(R.id.tV_close);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                return true;
            case MotionEvent.ACTION_MOVE:
                float moveY = event.getY() - iDownY;
                float currentY = getY();

                //向上滑动viewpager整体移动
                if (currentY + moveY < 0 && currentY + moveY > -getHeight() / 2) {

                }

        }
        return super.onTouchEvent(event);
    }

    public void doPagerUp(float moveY,float currentY){
        mMaxY=moveY+currentY;
        setTranslationY(mMaxY);
    }
}
