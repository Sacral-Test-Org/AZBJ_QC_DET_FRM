package com.azbj.qc.dto;

public class ViewImagesDTO {
    private String solutionId;
    private String parentContractId;
    private String policyReferenceNumber;

    // Getters and Setters
    public String getSolutionId() {
        return solutionId;
    }

    public void setSolutionId(String solutionId) {
        this.solutionId = solutionId;
    }

    public String getParentContractId() {
        return parentContractId;
    }

    public void setParentContractId(String parentContractId) {
        this.parentContractId = parentContractId;
    }

    public String getPolicyReferenceNumber() {
        return policyReferenceNumber;
    }

    public void setPolicyReferenceNumber(String policyReferenceNumber) {
        this.policyReferenceNumber = policyReferenceNumber;
    }
}