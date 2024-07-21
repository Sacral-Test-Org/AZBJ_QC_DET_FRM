package com.azbj.qc.dto;

public class ResetRequestDTO {
    private String policyRef;

    public ResetRequestDTO() {}

    public ResetRequestDTO(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }
}