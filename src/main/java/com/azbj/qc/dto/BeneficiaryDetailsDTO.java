package com.azbj.qc.dto;

import java.util.Date;

public class BeneficiaryDetailsDTO {
    private Date appDob;
    private String appName;
    private String appRelation;

    // Getters and Setters
    public Date getAppDob() {
        return appDob;
    }

    public void setAppDob(Date appDob) {
        this.appDob = appDob;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppRelation() {
        return appRelation;
    }

    public void setAppRelation(String appRelation) {
        this.appRelation = appRelation;
    }
}