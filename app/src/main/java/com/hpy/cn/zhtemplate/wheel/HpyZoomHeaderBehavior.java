package com.hpy.cn.zhtemplate.wheel;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.mvp.Details.Listener.AppBarStateChangeListener;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/13.
 */

public class HpyZoomHeaderBehavior extends CoordinatorLayout.Behavior<View> {

    private HpyZoomHeaderView mDependency;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private boolean isFirst = true;

    public HpyZoomHeaderBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof HpyZoomHeaderView;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        return super.onDependentViewChanged(parent, child, dependency);
    }

    /**
     * 初始化
     */
    public void init(final AppBarLayout child, View dependcy) {
        if (isFirst) {
            isFirst = false;
            mDependency = (HpyZoomHeaderView) dependcy;
            mDependency.setmAppBarLayout(child);
            mCollapsingToolbarLayout = (CollapsingToolbarLayout) child.findViewById(R.id.collapsing_toolbar_layout);
            child.addOnOffsetChangedListener(new AppBarStateChangeListener() {
                @Override
                public void onStateChanged(AppBarLayout appBarLayout, State state) {
                    if (state == State.EXPANDED) {
                        mCollapsingToolbarLayout.setTitle(null);
                        //展开状态
                        if (child.getChildAt(0).getY() == 0) {
                            mDependency.restore(mDependency.getY());
                        }
                    } else if (state == State.COLLAPSED) {
                        //折叠状态
                        mCollapsingToolbarLayout.setTitle("testtile");
                        mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
                    } else {
                        //中间状态
                        mCollapsingToolbarLayout.setTitle(null);
                    }

                }
            });
        }

    }


    @Override
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View child,
                                       View directTargetChild, View target, int nestedScrollAxes) {
        //只关心垂直事件
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public boolean onNestedFling(CoordinatorLayout coordinatorLayout, View child, View target,
                                 float velocityX, float velocityY, boolean consumed) {

        //向下Fling并且到顶部
        if (velocityY < 0 && ((RecyclerView) target).getChildAt(0).getY() == 0) {
            mDependency.restore(mDependency.getY());
        }
        return super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed);
    }

}
