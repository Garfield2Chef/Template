package com.hpy.cn.zhtemplate.mvp.Splash;

import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.BasePresenterImpl;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.TestEntity;
import com.hpy.cn.zhtemplate.retrofit.ApiCallback;
import com.hpy.cn.zhtemplate.retrofit.ApiStores;
import com.hpy.cn.zhtemplate.retrofit.AppClient;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

class SplashPresenter extends BasePresenterImpl<SplashView> {
    SplashPresenter(SplashView view){attachView(view);}

    //加载测试数据
    public void loadData(String dataType,String number,String page){
        addSubscription(apiStores.getFromGank(dataType, number, page), new ApiCallback<TestEntity>() {
            @Override
            public void onSuccess(TestEntity model) {

                mvpView.showGetSuccess(model);
            }

            @Override
            public void onFailure(String msg) {
                mvpView.showGetFail(msg);
            }

            @Override
            public void onFinish() {
                        //隐藏
            }
        });
    }

    //加载广告页
    public void getPic(String url){
        Picasso.with(Myapplication.getInstance()).load("http://192.168.168.249:8080/OAM/uploadFile/images/36d7e27a-90be-42ec-857b-ff5f1309c12d.jpg").into(mvpView.getIvSplash(), new Callback() {
            @Override
            public void onSuccess() {
                ToastUtils.showShortToastSafe(Myapplication.getInstance(),"成功");
            }

            @Override
            public void onError() {
                ToastUtils.showShortToastSafe(Myapplication.getInstance(),"失败");
                if(mvpView!=null)
                { Picasso.with(Myapplication.getInstance()).load(R.drawable.login).into(mvpView.getIvSplash());}
            }
        });

    }
}
