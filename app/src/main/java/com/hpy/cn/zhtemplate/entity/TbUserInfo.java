package com.hpy.cn.zhtemplate.entity;


import java.util.Date;

/**
 * Created by Mrkin on 2016/12/14.
 */

public class TbUserInfo {
    private String id;//	用户id
    private String uRealName;//	真实姓名
    private int uSex;//	性别 0:男;1:女 默认0
    private Date uBirthday;//	出生日期
    private String uTelephone;//	电话
    private String uEmail;//	邮箱
    private String uAddress;//	住址
    private Date createTime;//	创建时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuRealName() {
        return uRealName;
    }

    public void setuRealName(String uRealName) {
        this.uRealName = uRealName;
    }

    public int getuSex() {
        return uSex;
    }

    public void setuSex(int uSex) {
        this.uSex = uSex;
    }

    public Date getuBirthday() {
        return uBirthday;
    }

    public void setuBirthday(Date uBirthday) {
        this.uBirthday = uBirthday;
    }

    public String getuTelephone() {
        return uTelephone;
    }

    public void setuTelephone(String uTelephone) {
        this.uTelephone = uTelephone;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuAddress() {
        return uAddress;
    }

    public void setuAddress(String uAddress) {
        this.uAddress = uAddress;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
