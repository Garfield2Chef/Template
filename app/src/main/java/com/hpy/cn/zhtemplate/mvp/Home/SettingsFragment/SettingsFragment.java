package com.hpy.cn.zhtemplate.mvp.Home.SettingsFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.BasePresenterImpl;
import com.hpy.cn.zhtemplate.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends LazyLoadFragment {


    public static SettingsFragment newInstance()
    {
        SettingsFragment settingsFragment = new SettingsFragment();
        Bundle args = new Bundle();
        settingsFragment.setArguments(args);
        return settingsFragment;
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_settings;
    }

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected void lazyLoad() {

    }
}
