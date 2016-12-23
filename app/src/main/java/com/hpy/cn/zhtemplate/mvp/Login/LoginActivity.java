package com.hpy.cn.zhtemplate.mvp.Login;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.blankj.utilcode.utils.StringUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.MvpActivity;
import com.hpy.cn.zhtemplate.util.MD5Util;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {


    @BindView(R.id.eT_userName)
    EditText eTUserName;
    @BindView(R.id.eT_password)
    EditText eTPassword;
    @BindView(R.id.btn_signIn)
    Button btnSignIn;
    @BindView(R.id.activity_login)
    LinearLayout activityLogin;

    //非UI
    private Context mContext;
    private String userName;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        super.onCreate(savedInstanceState);

    }

    public void initData() {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public void LoginSuccess() {
        ToastUtils.showShortToast(mContext, "登陆成功");
    }

    @Override
    public void showFail(String result) {
        ToastUtils.showShortToast(mContext, "登陆失败，" + result);
    }

    @OnClick(R.id.btn_signIn)
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_signIn:
                userName=eTUserName.getText().toString().trim();
                password=eTPassword.getText().toString().trim();
//                String md5password = MD5Util.md5(password);
                mvpPresenter.login(userName,password);
                break;
        }
    }

    @Override
    public Activity getActivity() {
        return this;
    }
}
