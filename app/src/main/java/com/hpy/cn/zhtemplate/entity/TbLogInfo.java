package com.hpy.cn.zhtemplate.entity;



import java.io.Serializable;
import java.util.Date;


/**
 * Radio2Chef@Gmail.com
 *
 * Created by Mrkin on 2016/12/15.
 */

public class TbLogInfo implements Serializable {

    private static final long serialVersionUID = -4525284223917448101L;
    private String  id;//	日志id
    private String   uId;//	操作人id
    private String   url;//	url
    private String   lOperation;//	用户所做的操作
    private String   lContent;//	日志内容
    private Date createTime;//	创建日期
    private String lIp;//ip地址
    private String type;//类型web app

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getlOperation() {
        return lOperation;
    }

    public void setlOperation(String lOperation) {
        this.lOperation = lOperation;
    }

    public String getlContent() {
        return lContent;
    }

    public void setlContent(String lContent) {
        this.lContent = lContent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getlIp() {
        return lIp;
    }

    public void setlIp(String lIp) {
        this.lIp = lIp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
