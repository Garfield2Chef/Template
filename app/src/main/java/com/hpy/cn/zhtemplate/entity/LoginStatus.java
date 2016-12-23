package com.hpy.cn.zhtemplate.entity;

/**
 * Radio2Chef@Gmail.com
 * <p>
 * Created by HePy on 2016/12/21.
 */

public class LoginStatus {

    /**
     * msg : 请重新登录
     * code : 202
     * success : false
     */

    private String msg;
    private int code;
    private boolean success;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
