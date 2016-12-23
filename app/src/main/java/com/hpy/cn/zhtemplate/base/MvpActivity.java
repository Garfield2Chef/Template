package com.hpy.cn.zhtemplate.base;

import android.os.Bundle;
import android.os.PersistableBundle;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

public abstract class MvpActivity<P extends BasePresenterImpl> extends BaseActivity  {
    protected P mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mvpPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        initData();

    }

    protected abstract void initData();
    protected abstract P createPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mvpPresenter != null)
        {
            mvpPresenter.detachView();
        }
    }
    public void showLoading(){showProgressDialog();}

    public void hideLoading(){dismissProgressDialog();}
}
