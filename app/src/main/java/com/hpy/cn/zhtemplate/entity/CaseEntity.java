package com.hpy.cn.zhtemplate.entity;

/**
 * Radio2Chef@Gmail.com
 *
 * Created by HePy on 2016/12/27.
 */

public class CaseEntity {
    private String projectName;
    private String faultType;
    private String releaseTime;
    private String caseState;
    private String address;
    private String caseNo;
    private String casePicUrl;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getFaultType() {
        return faultType;
    }

    public void setFaultType(String faultType) {
        this.faultType = faultType;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public String getCaseState() {
        return caseState;
    }

    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCaseNo() {
        return caseNo;
    }

    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    public String getCasePicUrl() {
        return casePicUrl;
    }

    public void setCasePicUrl(String casePicUrl) {
        this.casePicUrl = casePicUrl;
    }
}
