package com.hpy.cn.zhtemplate.mvp.Home.MeFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.LazyLoadFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends LazyLoadFragment {


    public static MeFragment newInstance(){
        MeFragment meFragment = new MeFragment();
        Bundle args= new Bundle();
        meFragment.setArguments(args);
        return meFragment;
    }


    @Override
    protected int setContentView() {
        return R.layout.fragment_me;
    }

    @Override
    protected void lazyLoad() {

    }
}
