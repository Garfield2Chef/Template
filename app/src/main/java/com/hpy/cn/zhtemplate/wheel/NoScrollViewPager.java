package com.hpy.cn.zhtemplate.wheel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2016/12/27.
 */

public class NoScrollViewPager extends ViewPager {

    private boolean isPagingEnabled = false;
    public NoScrollViewPager(Context context) {
        super(context);
    }

    public NoScrollViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return this.isPagingEnabled && super.onInterceptTouchEvent(event);
    }

    @Override public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
    }
}