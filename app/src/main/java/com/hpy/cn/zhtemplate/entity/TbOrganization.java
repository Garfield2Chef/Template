package com.hpy.cn.zhtemplate.entity;



/**
 * Radio2Chef@Gmail.com
 *
 * Created by Marlon on 2016/11/16.
 */

public class TbOrganization  {

    private int oType;//	单位类型 0：单位；1：部门
    private String oName;//	单位名称
    private String oParentId;//	单位父id
    private String oDepartParentId;//	部门父id
    private String oShortName;//	单位简称
    private String oAddress;//	单位地址
    private String oContact;//	联系人
    private String oTel;//	联系电话
    private int level;//层级

    public int getoType() {
        return oType;
    }

    public void setoType(int oType) {
        this.oType = oType;
    }

    public String getoName() {
        return oName;
    }

    public void setoName(String oName) {
        this.oName = oName;
    }

    public String getoParentId() {
        return oParentId;
    }

    public void setoParentId(String oParentId) {
        this.oParentId = oParentId;
    }

    public String getoDepartParentId() {
        return oDepartParentId;
    }

    public void setoDepartParentId(String oDepartParentId) {
        this.oDepartParentId = oDepartParentId;
    }

    public String getoShortName() {
        return oShortName;
    }

    public void setoShortName(String oShortName) {
        this.oShortName = oShortName;
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress;
    }

    public String getoContact() {
        return oContact;
    }

    public void setoContact(String oContact) {
        this.oContact = oContact;
    }

    public String getoTel() {
        return oTel;
    }

    public void setoTel(String oTel) {
        this.oTel = oTel;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
