package com.azbj.qc.model;

public class Vendor {
    private String vendorCode;
    private String vendorName;
    private String branchCode;
    private Boolean branchDeleteFlag;

    // Constructors
    public Vendor() {}

    public Vendor(String vendorCode, String vendorName, String branchCode, Boolean branchDeleteFlag) {
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
        this.branchCode = branchCode;
        this.branchDeleteFlag = branchDeleteFlag;
    }

    // Getters and Setters
    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Boolean getBranchDeleteFlag() {
        return branchDeleteFlag;
    }

    public void setBranchDeleteFlag(Boolean branchDeleteFlag) {
        this.branchDeleteFlag = branchDeleteFlag;
    }
}
