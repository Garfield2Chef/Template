package com.hpy.cn.zhtemplate.mvp.Details;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.MvpActivity;
import com.hpy.cn.zhtemplate.mvp.Details.Listener.AppBarStateChangeListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaseDetailsActivity extends MvpActivity<CaseDetailsPresenter> implements CaseDetailsView {

    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCollapsingToolbarLayout;
    @BindView(R.id.activity_case_details)
    CoordinatorLayout mActivityCaseDetails;
    @BindView(R.id.appBarLayout)
    AppBarLayout mAppBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mAppBarLayout.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if(state==State.EXPANDED){
                    mCollapsingToolbarLayout.setTitle(null);
                    //展开状态
                }else if(state == State.COLLAPSED){
                    //折叠状态
                    mCollapsingToolbarLayout.setTitle("testtile");
                    mCollapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
                }else {
                    //中间状态
                    mCollapsingToolbarLayout.setTitle(null);
                }

            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected CaseDetailsPresenter createPresenter() {
        return new CaseDetailsPresenter(this);
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
