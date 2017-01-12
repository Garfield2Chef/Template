package com.hpy.cn.zhtemplate.mvp.Details.Listener;

import android.support.design.widget.AppBarLayout;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/11.
 */

public abstract class AppBarStateChangeListener implements AppBarLayout.OnOffsetChangedListener {
    public enum State{
        EXPANDED,
        COLLAPSED,
        ING

    }

    private State mCurrentState = State.ING;
    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (verticalOffset == 0) {
            if (mCurrentState != State.EXPANDED) {
                onStateChanged(appBarLayout, State.EXPANDED);
            }
            mCurrentState = State.EXPANDED;
        } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
            if (mCurrentState != State.COLLAPSED) {
                onStateChanged(appBarLayout, State.COLLAPSED);
            }
            mCurrentState = State.COLLAPSED;
        } else {
            if (mCurrentState != State.ING) {
                onStateChanged(appBarLayout, State.ING);
            }
            mCurrentState = State.ING;
        }
    }

    public abstract void onStateChanged(AppBarLayout appBarLayout, State state);
}
