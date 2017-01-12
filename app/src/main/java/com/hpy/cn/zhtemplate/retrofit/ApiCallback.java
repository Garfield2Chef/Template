package com.hpy.cn.zhtemplate.retrofit;

import com.blankj.utilcode.utils.LogUtils;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

public abstract class ApiCallback<M> extends Subscriber<M> {


    public abstract void onSuccess(M model);
    public abstract void onFailure(String msg);
    public abstract void onFinish();

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if(e instanceof HttpException){
            HttpException httpException = (HttpException) e;
            int code = httpException.code();
            String msg =httpException.getMessage();
            LogUtils.d("code="+code);
            if(code == 504){
                msg = "网络不给力";
            }
            if(code == 502 || code == 404){
                msg="服务器异常，请稍后再试";
            }
            onFailure(msg);
        }else {
            onFailure(e.getMessage());
        }
        onFinish();
    }

    @Override
    public void onNext(M model) {
        onSuccess(model);
    }

    @Override
    public void onCompleted() {
        onFinish();
    }
}
