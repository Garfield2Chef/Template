package com.hpy.cn.zhtemplate.mvp.Home.CaseFragment;

import com.hpy.cn.zhtemplate.base.BaseView;
import com.hpy.cn.zhtemplate.entity.CaseEntity;

import java.util.List;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2017/1/10.
 */

public interface CaseFMView extends BaseView {
    void showCaseList(List<CaseEntity> list);
    void showFail(String msg);
}
