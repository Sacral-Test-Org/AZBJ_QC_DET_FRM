package com.azbj.qc.model;

public class Enrichment {
    private String applicationNumber;
    private String formName;
    private String proposalNumber;
    private String customerName;

    public Enrichment() {}

    public Enrichment(String applicationNumber, String formName, String proposalNumber, String customerName) {
        this.applicationNumber = applicationNumber;
        this.formName = formName;
        this.proposalNumber = proposalNumber;
        this.customerName = customerName;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public String getProposalNumber() {
        return proposalNumber;
    }

    public void setProposalNumber(String proposalNumber) {
        this.proposalNumber = proposalNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}