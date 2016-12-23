package com.hpy.cn.zhtemplate.entity;




/**
 * Created by Marlon on 2016/11/16.
 */

public class TbRole {

    private String rName; 	// 角色名称
    private String rDescription;//角色描述

    public String getrName() {
        return rName;
    }

    public void setrName(String rName) {
        this.rName = rName;
    }

    public String getrDescription() {
        return rDescription;
    }

    public void setrDescription(String rDescription) {
        this.rDescription = rDescription;
    }
}