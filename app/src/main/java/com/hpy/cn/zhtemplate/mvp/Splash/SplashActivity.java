package com.hpy.cn.zhtemplate.mvp.Splash;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.MvpActivity;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.entity.TestEntity;
import com.hpy.cn.zhtemplate.mvp.Home.HomeActivity;
import com.hpy.cn.zhtemplate.mvp.Login.LoginActivity;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.wangyuwei.particleview.ParticleView;

public class SplashActivity extends MvpActivity<SplashPresenter> implements SplashView {
//UI元素
    @BindView(R.id.pV_anime)
    ParticleView mPVAnime;
    @BindView(R.id.iV_splash)
    ImageView iVSplash;
    @BindView(R.id.tV_seconds)
    TextView tVSeconds;
    @BindView(R.id.lLayout_skip)
    LinearLayout lLayoutSkip;
    @BindView(R.id.activity_splash)
    RelativeLayout activitySplash;
    @BindView(R.id.tV_skip)
    TextView tVSkip;
//  非UI元素
    private Context mContext;
    private MyCountDownTimer mc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        mPVAnime.startAnim();
        mPVAnime.setOnParticleAnimListener(new ParticleView.ParticleAnimListener() {
            @Override
            public void onAnimationEnd() {
                setView();
            }
        });
        String url = "http://192.168.168.249:8080/OAM/uploadFile/images/36d7e27a-90be-42ec-857b-ff5f1309c12d.jpg";
        mvpPresenter.getPic(url);
    }


    public void initData(){
        mc= new MyCountDownTimer(3000,1000);
        mContext = this;
    }

    private void enterHomeActivity() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void setView() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0,1);
        alphaAnimation.setDuration(1000);
        lLayoutSkip.setAnimation(alphaAnimation);
        iVSplash.setAnimation(alphaAnimation);
        lLayoutSkip.setVisibility(View.VISIBLE);
        iVSplash.setVisibility(View.VISIBLE);
        mc.start();
    }

    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public void showGetSuccess(TestEntity model) {
        ToastUtils.showShortToast(mContext,model.getResults().toString());
    }

    @Override
    public void showGetFail(String msg) {
        ToastUtils.showShortToast(mContext,msg);
    }

    @Override
    public ImageView getIvSplash() {
        return iVSplash;
    }

    @Override
    public Activity getActivity() {
        return this;
    }


    class MyCountDownTimer extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tVSeconds.setText(""+millisUntilFinished/1000);
        }

        @Override
        public void onFinish() {
            tVSeconds.setVisibility(View.GONE);
            tVSkip.setText("正在跳转");
            Intent intent = new Intent(mContext,LoginActivity.class);
            startActivity(intent);
            finish();

        }
    }
}
