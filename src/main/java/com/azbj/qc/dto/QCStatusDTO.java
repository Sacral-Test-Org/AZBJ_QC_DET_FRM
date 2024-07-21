package com.azbj.qc.dto;

public class QCStatusDTO {
    private String policyNumber;
    private String qcStatus;
    private String errorMessage;
    private boolean isBotUser;

    // Getters and Setters
    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isBotUser() {
        return isBotUser;
    }

    public void setBotUser(boolean isBotUser) {
        this.isBotUser = isBotUser;
    }
}
