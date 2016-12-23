package com.hpy.cn.zhtemplate.retrofit;

import android.app.Application;

import com.blankj.utilcode.utils.AppUtils;
import com.blankj.utilcode.utils.NetworkUtils;
import com.blankj.utilcode.utils.ToastUtils;
import com.hpy.cn.zhtemplate.BuildConfig;
import com.hpy.cn.zhtemplate.base.Myapplication;
import com.hpy.cn.zhtemplate.util.FileUtils;
import com.hpy.cn.zhtemplate.util.StaticUtils;

import java.io.File;
import java.io.IOException;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.R.attr.path;

/**
 * Created by HePy on 2016/11/28.
 */

public class AppClient {
    private static Retrofit mRetrofit;
    public static Retrofit createRetrofit(){
        if(mRetrofit==null){
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if(BuildConfig.DEBUG){
                //Log信息拦截器
                HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
                loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                //设置Debug Log模式
                builder.addInterceptor(loggingInterceptor);
            }
            //拦截器
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    if (!NetworkUtils.isAvailableByPing(Myapplication.getInstance())) {
                        request = request.newBuilder()
                                .cacheControl(CacheControl.FORCE_NETWORK)//用缓存的话会出现504
                                .build();
//                        ToastUtils.showShortToast(Myapplication.getInstance(),"暂无网络");//子线程安全显示Toast
                    }

                    Response response = chain.proceed(request);
                    if (NetworkUtils.isAvailableByPing(Myapplication.getInstance())) {
                        int maxAge = 60 * 60; // read from cache for 1 minute
                        response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, max-age=" + maxAge)
                                .build();
                    } else {
                        int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                        response.newBuilder()
                                .removeHeader("Pragma")
                                .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                                .build();
                    }
                    return response;
                }
            };

            //设置缓存路径
            File httpCacheDirectory = new File(FileUtils.getDynamicCacheDir(Myapplication.getInstance()), "hpy_cache");
            int cacheSize = 10 * 1024 * 1024;
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            OkHttpClient okHttpClient = builder
                    .addInterceptor(interceptor)
                    .build();
            mRetrofit = new Retrofit.Builder()
                    //请求的url
                    .baseUrl(StaticUtils.BASEURL)
                    //设置Rxjava适配器
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return  mRetrofit;
    }
}
