package com.hpy.cn.zhtemplate.base;

import android.app.Activity;
import android.content.Context;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

public interface BaseView {
    void showLoading();
    void hideLoading();
    Activity getActivity();
}
