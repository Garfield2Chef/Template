package com.hpy.cn.zhtemplate.mvp.Home.adapter;

import android.content.Intent;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blankj.utilcode.utils.LogUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.mvp.Details.CaseDetailsActivity;
import com.hpy.cn.zhtemplate.mvp.Home.HomeActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2016/12/27.
 */

public class CaseRecyclerAdapter extends RecyclerView.Adapter<CaseRecyclerAdapter.ViewHolder> implements View.OnClickListener {


    private List<CaseEntity> mList = new ArrayList<>();
    private View mView;
    private ViewHolder mViewHolder;
    private RecyclerviewOnItemClickListener onItemClickListener;


    public CaseRecyclerAdapter(List<CaseEntity> caseEntityList) {
        mList = caseEntityList;
    }

    /**
     * 更新数据时，更新UI
     */
    public void updateData(List<CaseEntity> caseEntityList) {
        mList = caseEntityList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //
        mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_case, parent, false);
        mViewHolder = new ViewHolder(mView);
        mView.setOnClickListener(this);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Picasso.with(Myapplication.getInstance()).load(mList.get(position).getCasePicUrl()).into(holder.iVCasePic, new Callback() {
            @Override
            public void onSuccess() {
                LogUtils.i("图片加载成功"+mList.get(position).getCasePicUrl());
            }

            @Override
            public void onError() {
                LogUtils.i("图片加载失败");
                Picasso.with(Myapplication.getInstance()).load(R.drawable.default_image).into(holder.iVCasePic);
            }
        });
        holder.itemView.setTag(mList.get(position));
        holder.tVProjectName.setText(mList.get(position).getProjectName());
        holder.tVCaseNo.setText(mList.get(position).getCaseNo());
        holder.tVAddress.setText(mList.get(position).getAddress());
        holder.tVReleaseTime.setText(mList.get(position).getReleaseTime());
        holder.tVFaultType.setText(mList.get(position).getFaultType());
        //根据状态替换图片
        if(mList.get(position).getCaseState().equals("1")){
            Picasso.with(Myapplication.getInstance()).load(R.drawable.stamp_waiting).into(holder.iVStampPic);
        }
        else  {
            Picasso.with(Myapplication.getInstance()).load(R.drawable.stamp_arrived).into(holder.iVStampPic);
        }


    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener!=null){
            onItemClickListener.onItemClick(v, (CaseEntity) v.getTag());
        }

    }


    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tV_projectName)
        TextView tVProjectName;
        @BindView(R.id.tV_caseNo)
        TextView tVCaseNo;
        @BindView(R.id.tV_faultType)
        TextView tVFaultType;
        @BindView(R.id.tV_address)
        TextView tVAddress;
        @BindView(R.id.tV_releaseTime)
        TextView tVReleaseTime;
        @BindView(R.id.iV_casePic)
        ImageView iVCasePic;
        @BindView(R.id.iV_stampPic)
        ImageView iVStampPic;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    /**
     * 设置行间样式的类
     */
    static public class SpaceItemDecoration extends RecyclerView.ItemDecoration{
        private int mSpace;
        private int mTop;
        private int mBottom;
        private int mLeft;
        private int mRight;
        public SpaceItemDecoration(int space){
            mSpace=space;
        }
        public SpaceItemDecoration(int top,int bottom,int left,int right){
            mTop=top;
            mBottom=bottom;
            mLeft=left;
            mRight=right;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            //outRect.top outRect.bottom outRect.right outRect.left
            if(mSpace!=0){
                outRect.top=mSpace;
                outRect.bottom=mSpace;
                outRect.right=mSpace;
                outRect.left=mSpace;
            }
            else {
                outRect.top=mTop;
                outRect.bottom=mBottom;
                outRect.right=mRight;
                outRect.left=mLeft;
            }
        }
    }


    public void setOnItemClickListener(RecyclerviewOnItemClickListener listener){
        this.onItemClickListener=listener;
    }

    public interface RecyclerviewOnItemClickListener{
        void onItemClick(View view,CaseEntity caseEntity);
    }
}
