package com.hpy.cn.zhtemplate.mvp.Details;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.widget.NestedScrollView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.LogUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.MvpActivity;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.wheel.HpyZoomHeaderView;
import com.hpy.cn.zhtemplate.wheel.HpyZoomHeaderViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CaseDetailsActivity extends MvpActivity<CaseDetailsPresenter> implements CaseDetailsView {

    @BindView(R.id.tV_close)
    TextView tvClose;
    @BindView(R.id.viewPager)
    HpyZoomHeaderViewPager mViewPager;
    @BindView(R.id.zoomHeader)
    HpyZoomHeaderView mZoomHeader;
    @BindView(R.id.activity_case_details)
    CoordinatorLayout mActivityCaseDetails;
    @BindView(R.id.nestedScrollView)
    NestedScrollView nestedScrollView;

    private List<CaseEntity> mList ;

    private DetalisAdapter mDetalisAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_case_details);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mViewPager.setOffscreenPageLimit(4);
        mViewPager.setAdapter(mDetalisAdapter);
    }



    @Override
    protected void initData() {
        mList = new ArrayList<>();
        mList = (List<CaseEntity>) getIntent().getSerializableExtra("list");
        mDetalisAdapter = new DetalisAdapter(mList);

    }

    @Override
    protected CaseDetailsPresenter createPresenter() {
        return new CaseDetailsPresenter(this);
    }

    @Override
    public Activity getActivity() {
        return this;
    }

    /**
     * ViewPager适配器
     */
    class DetalisAdapter extends PagerAdapter {
        private List<View> mViews;
        private List<CaseEntity> mList;

        public DetalisAdapter(List<CaseEntity> list) {
            mList = list;
            mViews = new ArrayList<>();
            for (CaseEntity caseEntity : mList) {
                mViews.add(View.inflate(CaseDetailsActivity.this, R.layout.item_details_image, null));
            }

        }


        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        /**
         * 添加初始化view
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            mViews.get(position).findViewById(R.id.iV_addressPic).setBackgroundResource(R.drawable.pic2);
            container.addView(mViews.get(position));
            return mViews.get(position);
        }

        /**
         * 删除
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViews.get(position));
        }

    }

    @Override
    public void onBackPressed() {

        if (mZoomHeader.isExpand()) {
            mZoomHeader.restore(mZoomHeader.getY());
        } else {
            finish();
        }
    }

}
