package com.hpy.cn.zhtemplate.mvp.Home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.hpy.cn.zhtemplate.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
    }


}
