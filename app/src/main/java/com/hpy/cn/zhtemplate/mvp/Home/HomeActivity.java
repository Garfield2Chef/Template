package com.hpy.cn.zhtemplate.mvp.Home;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.MvpActivity;
import com.hpy.cn.zhtemplate.mvp.Home.CaseFragment.CaseFragment;
import com.hpy.cn.zhtemplate.mvp.Home.MeFragment.MeFragment;
import com.hpy.cn.zhtemplate.mvp.Home.SearchFragment.SearchFragment;
import com.hpy.cn.zhtemplate.mvp.Home.SettingsFragment.SettingsFragment;
import com.hpy.cn.zhtemplate.mvp.Home.adapter.MyFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends MvpActivity<HomePresenter> implements HomeView {

    @BindView(R.id.bottom_tab)
    BottomNavigationView mBottomTab;
    @BindView(R.id.layout)
    CoordinatorLayout mLayout;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.viewPager)
    ViewPager mViewPager;


    List<Fragment> fragmentList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void initData() {
        //添加监听
        mToolbar.setTitle("中环");
        mToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(mToolbar);

        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_QR:
                        ToastUtils.showShortToastSafe(getActivity(), "点击了二维码扫描按钮");
                        break;
                }
                return false;
            }
        });

        //添加fragment
        fragmentList = new ArrayList<>();
        fragmentList.add(CaseFragment.newInstance());
        fragmentList.add(SearchFragment.newInstance());
        fragmentList.add(MeFragment.newInstance());
        fragmentList.add(SettingsFragment.newInstance());
        final MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter(getSupportFragmentManager(),fragmentList);
        mViewPager.setAdapter(myFragmentAdapter);


        mBottomTab.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.action_home:
                        mViewPager.setCurrentItem(0);

                        return true;
                    case R.id.action_search:
                        mViewPager.setCurrentItem(1);

                        return true;
                    case R.id.action_me:
                        mViewPager.setCurrentItem(2);

                        return true;
                    case R.id.action_setting:
                        mViewPager.setCurrentItem(3);

                     return true;
                }
                return true;
            }
        });
    }

    /**
     * 左上角menu按钮替换
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_items, menu);
        return true;
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }


    @Override
    public Activity getActivity() {
        return this;
    }


}
