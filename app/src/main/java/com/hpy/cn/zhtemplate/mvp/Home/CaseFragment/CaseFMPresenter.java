package com.hpy.cn.zhtemplate.mvp.Home.CaseFragment;

import com.hpy.cn.zhtemplate.base.BasePresenterImpl;
import com.hpy.cn.zhtemplate.base.BasePresneter;
import com.hpy.cn.zhtemplate.entity.CaseEntity;
import com.hpy.cn.zhtemplate.entity.RequestEntity;
import com.hpy.cn.zhtemplate.retrofit.ApiCallback;
import com.hpy.cn.zhtemplate.util.StaticUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/10.
 */

public class CaseFMPresenter extends BasePresenterImpl<CaseFMView> {
    CaseFMPresenter(CaseFMView view){attachView(view);}

    public void loadCaseList(){
//      addSubscription(apiStores.findCaseList(""), new ApiCallback<List<CaseEntity>>() {
//          @Override
//          public void onSuccess(List<CaseEntity> model) {
//            mvpView.showCaseList(model);
//          }
//
//          @Override
//          public void onFailure(String msg) {
//                mvpView.showFail(msg);
//          }
//
//          @Override
//          public void onFinish() {
//
//          }
//      });
        List<CaseEntity> model = new ArrayList<>();
        for(int i=0;i<10;i++){

            CaseEntity caseEntity = new CaseEntity();
            caseEntity.setAddress("address:"+i);
            caseEntity.setCaseNo("caseNo:"+i);
            caseEntity.setFaultType("faultType"+i);
            caseEntity.setReleaseTime("releaseTime"+i);
            caseEntity.setProjectName("projectName"+i);
            caseEntity.setCasePicUrl("pictrue");
            caseEntity.setCaseState(i%2==0?"1":"2");
            model.add(caseEntity);
        }
        if(mvpView!=null)
        {mvpView.showCaseList(model);}
    }


}
