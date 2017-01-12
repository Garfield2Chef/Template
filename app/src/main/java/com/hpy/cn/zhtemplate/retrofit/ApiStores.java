package com.hpy.cn.zhtemplate.retrofit;

import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.entity.LoginStatus;

import com.hpy.cn.zhtemplate.entity.RequestEntity;
import com.hpy.cn.zhtemplate.entity.TbUser;
import com.hpy.cn.zhtemplate.entity.TestEntity;

import java.net.PasswordAuthentication;
import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/15.
 */

public interface ApiStores {

    //测试
    @GET("{dataType}/{requestNumber}/{page}")
    Observable<TestEntity> getFromGank(@Path("dataType") String dataType,@Path("requestNumber") String requestNumber,@Path("page") String page);

    @POST("{action}")
    Observable<RequestEntity<TbUser>> accessServerByAction(@Path("action")String action,@Query("loginName") String loginName, @Query("password") String password);

    //findCaselist
    @POST("{action}")
    Observable<RequestEntity<List<CaseEntity>>> findCaseList(@Path("action")String action);

}
