package com.hpy.cn.zhtemplate.base;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/14.
 */

public interface BasePresneter<V> {
    void attachView(V view);

    void detachView();
}
