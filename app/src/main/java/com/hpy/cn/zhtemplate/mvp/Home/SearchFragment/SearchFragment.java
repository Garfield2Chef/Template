package com.hpy.cn.zhtemplate.mvp.Home.SearchFragment;


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
public class SearchFragment extends LazyLoadFragment {

    public static SearchFragment newInstance(){
        SearchFragment searchFragment = new SearchFragment();
        Bundle args=new Bundle();
        searchFragment.setArguments(args);
        return searchFragment;
    }
    @Override
    protected int setContentView() {
        return R.layout.fragment_search;
    }

    @Override
    protected void lazyLoad() {

    }

}
