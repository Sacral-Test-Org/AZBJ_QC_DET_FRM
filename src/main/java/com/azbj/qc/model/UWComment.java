package com.azbj.qc.model;

import java.util.Date;

public class UWComment {
    private String policyNumber;
    private String userProfile;
    private String comment;
    private Date date;

    public UWComment() {}

    public UWComment(String policyNumber, String userProfile, String comment, Date date) {
        this.policyNumber = policyNumber;
        this.userProfile = userProfile;
        this.comment = comment;
        this.date = date;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(String userProfile) {
        this.userProfile = userProfile;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}