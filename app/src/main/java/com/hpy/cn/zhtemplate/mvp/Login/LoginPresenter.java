package com.hpy.cn.zhtemplate.mvp.Login;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.BasePresenterImpl;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.LoginStatus;
import com.hpy.cn.zhtemplate.entity.RequestEntity;
import com.hpy.cn.zhtemplate.entity.TbUser;
import com.hpy.cn.zhtemplate.mvp.Home.HomeActivity;
import com.hpy.cn.zhtemplate.retrofit.ApiCallback;
import com.hpy.cn.zhtemplate.util.StaticUtils;

import rx.Observable;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/20.
 */

public class LoginPresenter extends BasePresenterImpl<LoginView> {
    public LoginPresenter(LoginView v){attachView(v);}

    public void login(String username, String password){
//
//        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password))
//        {
//            mvpView.showFail((String) Myapplication.getFromResource(R.string.cant_be_empty,""));
//            return;
//        }
//        mvpView.showLoading();
//        addSubscription(apiStores.accessServerByAction(StaticUtils.LOGIN_ACTION,username, password), new ApiCallback<RequestEntity<TbUser>>() {
//
//            @Override
//            public void onSuccess(RequestEntity<TbUser> model) {
//                mvpView.LoginSuccess();
//                Intent intent = new Intent(Myapplication.getInstance(), HomeActivity.class);
//                mvpView.getActivity().startActivity(intent);
//                mvpView.getActivity().finish();
//            }
//
//            @Override
//            public void onFailure(String msg) {
//                mvpView.showFail(msg);
//            }
//
//            @Override
//            public void onFinish() {
//                mvpView.hideLoading();
//            }
//        });
                Intent intent = new Intent(Myapplication.getInstance(), HomeActivity.class);
                mvpView.getActivity().startActivity(intent);
                mvpView.getActivity().finish();

    }

}
