package com.hpy.cn.zhtemplate.base;

import com.hpy.cn.zhtemplate.retrofit.ApiStores;
import com.hpy.cn.zhtemplate.retrofit.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/14.
 */

public class BasePresenterImpl<V> implements BasePresneter<V> {
    public V  mvpView;
    private CompositeSubscription mCompositeSubscription;
    public ApiStores apiStores;
    @Override
    public void attachView(V view) {
        this.mvpView=view;
        apiStores=AppClient.createRetrofit().create(ApiStores.class);
    }

    @Override
    public void detachView() {
        this.mvpView=null;
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }

        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
