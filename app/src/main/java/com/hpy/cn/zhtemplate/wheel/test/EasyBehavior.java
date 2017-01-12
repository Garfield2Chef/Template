package com.hpy.cn.zhtemplate.wheel.test;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/11.
 */

public class EasyBehavior extends CoordinatorLayout.Behavior<TextView> {
    public EasyBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, TextView child, View dependency) {
            //告知监听的是dependency是button
        return dependency instanceof Button;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, TextView child, View dependency) {
        child.setX(dependency.getX()+200);
        child.setY(dependency.getY()+200);
        child.setText(dependency.getX()+","+dependency.getY());
        return true;
    }
}
