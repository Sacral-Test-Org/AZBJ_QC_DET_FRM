package com.azbj.qc.dto;

public class ApplicationNumberDTO {
    private String applicationNumber;

    public ApplicationNumberDTO() {}

    public ApplicationNumberDTO(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }
}
