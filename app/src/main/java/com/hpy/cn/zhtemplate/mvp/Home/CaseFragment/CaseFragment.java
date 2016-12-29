package com.hpy.cn.zhtemplate.mvp.Home.CaseFragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.LazyLoadFragment;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.mvp.Home.adapter.CaseRecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CaseFragment extends LazyLoadFragment {

//    @BindView(R.id.recycView_case)
//    RecyclerView recycViewCase;

    private String TAG="CaseFragment";

   private List<CaseEntity> list;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static CaseFragment newInstance() {
        CaseFragment caseFragment = new CaseFragment();
        Bundle args = new Bundle();
        //if add something to args ,change the params;
        //args.putXXX()...
        caseFragment.setArguments(args);
        return caseFragment;
    }

    @Override
    protected int setContentView() {
        return R.layout.fragment_case;
    }

    @Override
    protected void lazyLoad() {
        list = new ArrayList<>();
        for(int i=0;i<=5;i++){
            CaseEntity caseEntity = new CaseEntity();
            caseEntity.setContent("content"+i);
            caseEntity.setTitle("title"+i);
            caseEntity.setPicurl("url"+i);
            list.add(caseEntity);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
//        initView();
        return rootView;
    }

//    public void initView(){
//        CaseRecyclerAdapter adapter = new CaseRecyclerAdapter(list);
//        recycViewCase.setAdapter(adapter);
//    }
}
