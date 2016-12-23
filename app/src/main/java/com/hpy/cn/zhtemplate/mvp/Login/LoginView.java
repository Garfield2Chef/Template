package com.hpy.cn.zhtemplate.mvp.Login;

import android.app.Activity;
import android.content.Context;

import com.hpy.cn.zhtemplate.base.BaseView;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/20.
 */

public interface LoginView extends BaseView {
    void LoginSuccess();
    void showFail(String result);

}
