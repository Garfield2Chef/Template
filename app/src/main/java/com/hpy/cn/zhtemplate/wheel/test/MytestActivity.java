package com.hpy.cn.zhtemplate.wheel.test;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;

import com.hpy.cn.zhtemplate.R;
import com.hpy.cn.zhtemplate.base.BaseActivity;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/6.
 */

public class MytestActivity extends Activity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        findViewById(R.id.btn).setOnTouchListener(new View.OnTouchListener() {

            @Override public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){

                    case MotionEvent.ACTION_MOVE:
                        v.setX(event.getRawX()-v.getWidth()/2);
                        v.setY(event.getRawY()-v.getHeight()/2);
                        break;
                }
                return false;
            }
        });

    }

}
