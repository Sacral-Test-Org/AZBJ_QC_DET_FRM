package com.azbj.qc.model;

public class PhysicalCopyStatus {
    private String policyNumber;
    private String physicalCopyStatus;

    public PhysicalCopyStatus() {}

    public PhysicalCopyStatus(String policyNumber, String physicalCopyStatus) {
        this.policyNumber = policyNumber;
        this.physicalCopyStatus = physicalCopyStatus;
    }

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
