package com.hpy.cn.zhtemplate.wheel;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.hpy.cn.zhtemplate.wheel.support.ZoomOutPageTransformer;

import cn.bingoogolapple.bgabanner.transformer.ZoomFadePageTransformer;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/12.
 */

public class HpyZoomHeaderViewPager extends ViewPager {
    public boolean canScroll = true;

    public HpyZoomHeaderViewPager(Context context) {
        super(context);
    }

    public HpyZoomHeaderViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        setPageTransformer(true,new ZoomOutPageTransformer());
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        return canScroll && super.onTouchEvent(ev);
    }

    //改变系统绘制顺序
    @Override
    protected int getChildDrawingOrder(int childCount, int i) {

        int position = getCurrentItem();
        if(position<0){
            return i;
        }else{
            if(i == childCount - 1){//这是最后一个需要刷新的item
                if(position>i){
                    position=i;
                }
                return position;
            }
            if(i == position){//这是原本要在最后一个刷新的item
                return childCount - 1;
            }
        }
        return i;
    }
}
