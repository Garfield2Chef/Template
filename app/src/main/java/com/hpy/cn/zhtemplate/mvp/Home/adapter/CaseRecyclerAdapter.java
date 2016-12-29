package com.hpy.cn.zhtemplate.mvp.Home.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wingsofts.dragphotoview.DragPhotoView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2016/12/27.
 */

public class CaseRecyclerAdapter extends RecyclerView.Adapter<CaseRecyclerAdapter.ViewHolder> {

    private List<CaseEntity> mList = new ArrayList<>();
    private View mView;
    private ViewHolder mViewHolder;

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
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.tVContent.setText(mList.get(position).getContent());
        holder.tVTitle.setText(mList.get(position).getTitle());
        Picasso.with(Myapplication.getInstance()).load(mList.get(position).getPicurl()).into(holder.iVPic, new Callback() {
            @Override
            public void onSuccess() {

            }

            @Override
            public void onError() {
                ToastUtils.showShortToastSafe(Myapplication.getInstance(),"图片获取失败"+mList.get(position).getPicurl());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iV_pic)
        DragPhotoView iVPic;
        @BindView(R.id.tV_title)
        TextView tVTitle;
        @BindView(R.id.tV_content)
        TextView tVContent;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
