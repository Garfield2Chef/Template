package com.hpy.cn.zhtemplate.wheel;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
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
    //是否展开
    private boolean isExpand = false;

    private AppBarLayout mAppBarLayout;

    private final int ANIMATE_LENGTH = 300;

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
        mCloseText = (TextView) findViewById(R.id.tV_close);
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
                    doPagerUp(moveY, currentY);
                }
                if (currentY + moveY > 0 && currentY + moveY < 800) {
                    doPagerDown(moveY, currentY);
                    //消费掉该事件
                    return true;
                }
            case MotionEvent.ACTION_UP:

                float upY = event.getY() - iDownY;
                float currentUpY = getY();
                //超过阀值 结束Activity

                if (upY + currentUpY > 190) {
                    finish();
                }

                //不在任何阀值  恢复
                if (currentUpY + upY > -getHeight() / 4 && currentUpY + upY < 190) {
                    restore(upY + currentUpY);
                }

                //超过展开阀值
                if (upY + currentUpY < -getHeight() / 4) {
                    if (upY + currentUpY < mMaxY) {
                        expand(mMaxY);
                    } else {
                        expand(upY + currentUpY);
                    }
                }
                return true;
        }
        return super.onTouchEvent(event);
    }

    private void doPagerDown(float moveY, float currentY) {
        int pos = mViewPager.getCurrentItem();
        View v = mViewPager.getChildAt(pos);
        v.setTranslationY((currentY + moveY) / 4);
        mCloseText.setAlpha(0.8f);
    }

    public void doPagerUp(float moveY, float currentY) {
        mMaxY = moveY + currentY;
        setTranslationY(mMaxY);
        mCloseText.setAlpha(0f);
    }

    public void restore(float y) {
        mCloseText.setAlpha(0f);
        if (y > mFirstY) {
            ValueAnimator closeVa = ValueAnimator.ofFloat(1, 0);
            closeVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    mCloseText.setAlpha((Float) animation.getAnimatedValue());
                }
            });
            closeVa.setDuration(ANIMATE_LENGTH);
            closeVa.start();
        }

//        mNestedScrollView.scrollToPosition(0);
        ValueAnimator restoreVa = ValueAnimator.ofFloat(y, mFirstY);
        restoreVa.setInterpolator(new DecelerateInterpolator());
        restoreVa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float y = (float) animation.getAnimatedValue();
                setTranslationY(y);
                isExpand = false;
                mViewPager.canScroll = true;
            }
        });
        restoreVa.setDuration(ANIMATE_LENGTH);
        restoreVa.start();

        //禁止滑动
//        ((CtrlLinearLayoutManager) mRecyclerView.getLayoutManager()).setScrollEnabled(false);

    }


    private void expand(float y) {

        ValueAnimator va = ValueAnimator.ofFloat(y, -getHeight() / 3);
        va.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float y = (float) animation.getAnimatedValue();
                mViewPager.canScroll = false;
                setTranslationY(y);
                isExpand = true;
            }
        });

        va.setInterpolator(new DecelerateInterpolator());
        va.setDuration(ANIMATE_LENGTH);
        va.start();


    }

    public boolean isExpand() {
        return isExpand;
    }


    private void finish() {
        TranslateAnimation finishTa = new TranslateAnimation(0, 0, 0, 1000);
        finishTa.setDuration(ANIMATE_LENGTH);
        finishTa.setFillAfter(true);
        finishTa.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                ((Activity) getContext()).finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        startAnimation(finishTa);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {

        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                iDownY = (int) ev.getY();

                break;
            case MotionEvent.ACTION_MOVE:
                int moveY = (int) ev.getY();
                if (Math.abs(moveY - iDownY) > mTouchSlop) {

                    return true;
                }
        }
        return super.onInterceptTouchEvent(ev);
    }

    public AppBarLayout getmAppBarLayout() {
        return mAppBarLayout;
    }

    public void setmAppBarLayout(AppBarLayout mAppBarLayout) {
        this.mAppBarLayout = mAppBarLayout;
    }
}
