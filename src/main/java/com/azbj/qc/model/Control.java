package com.azbj.qc.model;

import java.util.Date;
import java.util.List;

public class Control {
    // Fields for the CONTROL block
    private String policyRef;
    private String flg;
    private String qcStatus;

    // Fields for 'View Images' functionality
    private String solutionId;
    private String parentContractId;
    private String policyReferenceNumber;

    // Fields for dispatch details
    private String dispatchShipmentNumber;
    private String reference;
    private String weight;
    private String deliveryType;
    private String destinationType;
    private String gmValue;

    // Fields for QC section
    private String ci;
    private Integer flg;

    // Fields for user profile and comments
    private UserProfile userProfile;
    private List<Comment> comments;

    // Fields for skip application process
    private String blockFlag;
    private String blockReason;
    private Date delinkDate;
    private String delinkUser;
    private String blockComments;

    // Fields for document file path
    private String filePath;

    // Fields for QC verification
    private String applicationNumber;
    private String appointeeGender;
    private BeneficiaryDetailsDTO beneficiaryDetails;

    // Getters and Setters
    public String getPolicyRef() {
        return policyRef;
    }

    public void setPolicyRef(String policyRef) {
        this.policyRef = policyRef;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

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

    public String getDispatchShipmentNumber() {
        return dispatchShipmentNumber;
    }

    public void setDispatchShipmentNumber(String dispatchShipmentNumber) {
        this.dispatchShipmentNumber = dispatchShipmentNumber;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public String getDestinationType() {
        return destinationType;
    }

    public void setDestinationType(String destinationType) {
        this.destinationType = destinationType;
    }

    public String getGmValue() {
        return gmValue;
    }

    public void setGmValue(String gmValue) {
        this.gmValue = gmValue;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getFlg() {
        return flg;
    }

    public void setFlg(Integer flg) {
        this.flg = flg;
    }

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getBlockFlag() {
        return blockFlag;
    }

    public void setBlockFlag(String blockFlag) {
        this.blockFlag = blockFlag;
    }

    public String getBlockReason() {
        return blockReason;
    }

    public void setBlockReason(String blockReason) {
        this.blockReason = blockReason;
    }

    public Date getDelinkDate() {
        return delinkDate;
    }

    public void setDelinkDate(Date delinkDate) {
        this.delinkDate = delinkDate;
    }

    public String getDelinkUser() {
        return delinkUser;
    }

    public void setDelinkUser(String delinkUser) {
        this.delinkUser = delinkUser;
    }

    public String getBlockComments() {
        return blockComments;
    }

    public void setBlockComments(String blockComments) {
        this.blockComments = blockComments;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getApplicationNumber() {
        return applicationNumber;
    }

    public void setApplicationNumber(String applicationNumber) {
        this.applicationNumber = applicationNumber;
    }

    public String getAppointeeGender() {
        return appointeeGender;
    }

    public void setAppointeeGender(String appointeeGender) {
        this.appointeeGender = appointeeGender;
    }

    public BeneficiaryDetailsDTO getBeneficiaryDetails() {
        return beneficiaryDetails;
    }

    public void setBeneficiaryDetails(BeneficiaryDetailsDTO beneficiaryDetails) {
        this.beneficiaryDetails = beneficiaryDetails;
    }
}

class UserProfile {
    // Define fields and methods for UserProfile
}

class Comment {
    // Define fields and methods for Comment
}

class BeneficiaryDetailsDTO {
    // Define fields and methods for BeneficiaryDetailsDTO
}
}