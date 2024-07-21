package com.azbj.qc.dto;

public class DispatchDTO {
    private String SHIP_NO;
    private String AWB_NO;
    private String DEL_TYPE = "I";
    private String VENDOR;
    private String DES_TYPE = "CUST";
    private String PICK_REQ_NO;
    private String PR_REF;
    private String CONSIGNEE_NAME;
    private String CON_ADD1;
    private String CON_ADD2;
    private String CON_ADD3;
    private String CON_CITY;
    private String CON_STATE;
    private String DES_PIN;
    private String WT;
    private String GM = "Grm";
    private String VEN_CODE;

    // Getters and Setters
    public String getSHIP_NO() {
        return SHIP_NO;
    }

    public void setSHIP_NO(String SHIP_NO) {
        this.SHIP_NO = SHIP_NO;
    }

    public String getAWB_NO() {
        return AWB_NO;
    }

    public void setAWB_NO(String AWB_NO) {
        this.AWB_NO = AWB_NO;
    }

    public String getDEL_TYPE() {
        return DEL_TYPE;
    }

    public void setDEL_TYPE(String DEL_TYPE) {
        this.DEL_TYPE = DEL_TYPE;
    }

    public String getVENDOR() {
        return VENDOR;
    }

    public void setVENDOR(String VENDOR) {
        this.VENDOR = VENDOR;
    }

    public String getDES_TYPE() {
        return DES_TYPE;
    }

    public void setDES_TYPE(String DES_TYPE) {
        this.DES_TYPE = DES_TYPE;
    }

    public String getPICK_REQ_NO() {
        return PICK_REQ_NO;
    }

    public void setPICK_REQ_NO(String PICK_REQ_NO) {
        this.PICK_REQ_NO = PICK_REQ_NO;
    }

    public String getPR_REF() {
        return PR_REF;
    }

    public void setPR_REF(String PR_REF) {
        this.PR_REF = PR_REF;
    }

    public String getCONSIGNEE_NAME() {
        return CONSIGNEE_NAME;
    }

    public void setCONSIGNEE_NAME(String CONSIGNEE_NAME) {
        this.CONSIGNEE_NAME = CONSIGNEE_NAME;
    }

    public String getCON_ADD1() {
        return CON_ADD1;
    }

    public void setCON_ADD1(String CON_ADD1) {
        this.CON_ADD1 = CON_ADD1;
    }

    public String getCON_ADD2() {
        return CON_ADD2;
    }

    public void setCON_ADD2(String CON_ADD2) {
        this.CON_ADD2 = CON_ADD2;
    }

    public String getCON_ADD3() {
        return CON_ADD3;
    }

    public void setCON_ADD3(String CON_ADD3) {
        this.CON_ADD3 = CON_ADD3;
    }

    public String getCON_CITY() {
        return CON_CITY;
    }

    public void setCON_CITY(String CON_CITY) {
        this.CON_CITY = CON_CITY;
    }

    public String getCON_STATE() {
        return CON_STATE;
    }

    public void setCON_STATE(String CON_STATE) {
        this.CON_STATE = CON_STATE;
    }

    public String getDES_PIN() {
        return DES_PIN;
    }

    public void setDES_PIN(String DES_PIN) {
        this.DES_PIN = DES_PIN;
    }

    public String getWT() {
        return WT;
    }

    public void setWT(String WT) {
        this.WT = WT;
    }

    public String getGM() {
        return GM;
    }

    public void setGM(String GM) {
        this.GM = GM;
    }

    public String getVEN_CODE() {
        return VEN_CODE;
    }

    public void setVEN_CODE(String VEN_CODE) {
        this.VEN_CODE = VEN_CODE;
    }
}