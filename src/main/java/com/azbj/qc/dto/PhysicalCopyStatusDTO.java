package com.azbj.qc.dto;

public class PhysicalCopyStatusDTO {
    private String policyNumber;
    private String physicalCopyStatus;

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPhysicalCopyStatus() {
        return physicalCopyStatus;
    }

    public void setPhysicalCopyStatus(String physicalCopyStatus) {
        this.physicalCopyStatus = physicalCopyStatus;
    }
}
