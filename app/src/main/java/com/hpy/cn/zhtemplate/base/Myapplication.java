package com.hpy.cn.zhtemplate.base;

import android.app.Application;
import android.content.res.XmlResourceParser;

import com.hpy.cn.zhtemplate.util.CrashHandler;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2016/11/28.
 */

public class Myapplication extends Application {
    public static Myapplication instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
    }

    public static Myapplication getInstance(){
        return instance;
    }

    public static Object getFromResource(int id,Object defaultObject){
        if(instance!=null && defaultObject instanceof XmlResourceParser)
        {
            defaultObject = instance.getResources().getAnimation(id);
        }
        else if(instance!=null && defaultObject instanceof Boolean)
        {
            defaultObject = instance.getResources().getBoolean(id);
        }
        else if(instance!=null && defaultObject instanceof String)
        {
            defaultObject = instance.getResources().getString(id);
        }
        else if(instance!=null && defaultObject instanceof Integer)
        {
            defaultObject = instance.getResources().getColor(id);
        }
        return defaultObject;
    }

}
