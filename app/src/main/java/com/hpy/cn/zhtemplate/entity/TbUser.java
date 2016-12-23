package com.hpy.cn.zhtemplate.entity;


/**
 * Created by Marlon on 2016/11/17.
 */

public class TbUser  {

    private String uName;//	账户名称
    private String uPassword;//	用户密码
    private int uLocked;//	是否锁定
    private String uDescription;//	用户描述
    private String uCredentialsSalt;//	加密盐
    private TbUserInfo userInfo;//用户信息扩展表

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuPassword() {
        return uPassword;
    }

    public void setuPassword(String uPassword) {
        this.uPassword = uPassword;
    }

    public int getuLocked() {
        return uLocked;
    }

    public void setuLocked(int uLocked) {
        this.uLocked = uLocked;
    }

    public String getuDescription() {
        return uDescription;
    }

    public void setuDescription(String uDescription) {
        this.uDescription = uDescription;
    }

    public String getuCredentialsSalt() {
        return uCredentialsSalt;
    }

    public void setuCredentialsSalt(String uCredentialsSalt) {
        this.uCredentialsSalt = uCredentialsSalt;
    }

    public TbUserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(TbUserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
