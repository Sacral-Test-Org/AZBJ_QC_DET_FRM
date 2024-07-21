package com.azbj.qc.dto;

import java.util.Date;

public class PolicyReferenceDTO {
    private String policyRef;
    private String status;
    private Date timestamp;

    // Constructors
    public PolicyReferenceDTO() {}

    public PolicyReferenceDTO(String policyRef, String status, Date timestamp) {
        this.policyRef = policyRef;
        this.status = status;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
