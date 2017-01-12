package com.hpy.cn.zhtemplate.mvp.Home.CaseFragment;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.LazyLoadFragment;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.mvp.Details.CaseDetailsActivity;
import com.hpy.cn.zhtemplate.mvp.Home.adapter.CaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CaseFragment extends LazyLoadFragment<CaseFMPresenter> implements CaseFMView {

   @BindView(R.id.recycView_case)
    RecyclerView recycViewCase;

    private String TAG="CaseFragment";

    private List<CaseEntity> mList=new ArrayList<>();
    private CaseRecyclerAdapter mAdapter;
    private Context mContext;
    private Activity mActivity;
    public static CaseFragment newInstance() {
        CaseFragment caseFragment = new CaseFragment();
        Bundle args = new Bundle();
        //if add something to args ,change the params;
        //args.putXXX()...
        caseFragment.setArguments(args);

        return caseFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=this.getContext();
        mActivity=this.getActivity();
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_case;
    }

    @Override
    protected CaseFMPresenter createPresenter() {
        return new CaseFMPresenter(this);
    }


    @Override
    protected void lazyLoad() {
    mvpPresenter.loadCaseList();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        initView();
        return rootView;
    }

    public void initView(){
        mAdapter =new CaseRecyclerAdapter(mList);
        CaseRecyclerAdapter.SpaceItemDecoration spaceItemDecoration = new CaseRecyclerAdapter.SpaceItemDecoration(10);
        recycViewCase.addItemDecoration(spaceItemDecoration);
        recycViewCase.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        //如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        recycViewCase.setHasFixedSize(true);
        mAdapter.setOnItemClickListener(new CaseRecyclerAdapter.RecyclerviewOnItemClickListener() {
            @Override
            public void onItemClick(View view, CaseEntity caseEntity) {
                Intent intent = new Intent(Myapplication.getInstance(), CaseDetailsActivity.class);
                startActivity(intent);
                mActivity.finish();


            }
        });
        recycViewCase.setAdapter(mAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showCaseList(List<CaseEntity> list) {
        mList=list;
    }

    @Override
    public void showFail(String msg) {

    }
}
