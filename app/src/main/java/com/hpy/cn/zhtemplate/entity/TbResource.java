package com.hpy.cn.zhtemplate.entity;


/**
 * Created by Marlon on 2016/11/16.
 */

public class TbResource {

    private String sParentId;	//	资源父id
    private String  sName;	//	资源名称
    private int  sType;	//	资源类型 0:菜单;1:功能
    private String  sKind;	//	资源类别 web、app
    private String sUrl;	//	资源url
    private String sIcon;	//	图标
    private int sIndex;	//	资源排序
    private int sHide;	//	是否隐藏
    private int level;//层级

    public String getsParentId() {
        return sParentId;
    }

    public void setsParentId(String sParentId) {
        this.sParentId = sParentId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public int getsType() {
        return sType;
    }

    public void setsType(int sType) {
        this.sType = sType;
    }

    public String getsKind() {
        return sKind;
    }

    public void setsKind(String sKind) {
        this.sKind = sKind;
    }

    public String getsUrl() {
        return sUrl;
    }

    public void setsUrl(String sUrl) {
        this.sUrl = sUrl;
    }

    public String getsIcon() {
        return sIcon;
    }

    public void setsIcon(String sIcon) {
        this.sIcon = sIcon;
    }

    public int getsIndex() {
        return sIndex;
    }

    public void setsIndex(int sIndex) {
        this.sIndex = sIndex;
    }

    public int getsHide() {
        return sHide;
    }

    public void setsHide(int sHide) {
        this.sHide = sHide;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
