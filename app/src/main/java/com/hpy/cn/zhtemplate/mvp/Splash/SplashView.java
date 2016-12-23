package com.hpy.cn.zhtemplate.mvp.Splash;

import android.widget.ImageView;

import com.hpy.cn.zhtemplate.base.BaseView;
import com.hpy.cn.zhtemplate.entity.TestEntity;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

public interface SplashView extends BaseView {
    void showGetSuccess(TestEntity model);

    void showGetFail(String msg);
    ImageView getIvSplash();
}
