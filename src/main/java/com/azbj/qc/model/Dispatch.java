package com.azbj.qc.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
public class Dispatch {

    @Id
    @Column(name = "SHIP_NO")
    private String shipNo;

    @Column(name = "AWB_NO")
    private String awbNo;

    @Column(name = "DEL_TYPE", columnDefinition = "varchar(255) default 'I'")
    private String delType = "I";

    @Column(name = "VENDOR")
    private String vendor;

    @Column(name = "DES_TYPE", columnDefinition = "varchar(255) default 'CUST'")
    private String desType = "CUST";

    @Column(name = "PICK_REQ_NO")
    private String pickReqNo;

    @Column(name = "PR_REF", insertable = false, updatable = false)
    private String prRef;

    @Column(name = "CONSIGNEE_NAME", insertable = false, updatable = false)
    private String consigneeName;

    @Column(name = "CON_ADD1", insertable = false, updatable = false)
    private String conAdd1;

    @Column(name = "CON_ADD2", insertable = false, updatable = false)
    private String conAdd2;

    @Column(name = "CON_ADD3", insertable = false, updatable = false)
    private String conAdd3;

    @Column(name = "CON_CITY", insertable = false, updatable = false)
    private String conCity;

    @Column(name = "CON_STATE", insertable = false, updatable = false)
    private String conState;

    @Column(name = "DES_PIN", insertable = false, updatable = false)
    private String desPin;

    @Column(name = "WT")
    private String wt;

    @Column(name = "GM", columnDefinition = "varchar(255) default 'Grm'")
    private String gm = "Grm";

    @Column(name = "VEN_CODE", insertable = false, updatable = false)
    private String venCode;

    // Getters and Setters

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getAwbNo() {
        return awbNo;
    }

    public void setAwbNo(String awbNo) {
        this.awbNo = awbNo;
    }

    public String getDelType() {
        return delType;
    }

    public void setDelType(String delType) {
        this.delType = delType;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDesType() {
        return desType;
    }

    public void setDesType(String desType) {
        this.desType = desType;
    }

    public String getPickReqNo() {
        return pickReqNo;
    }

    public void setPickReqNo(String pickReqNo) {
        this.pickReqNo = pickReqNo;
    }

    public String getPrRef() {
        return prRef;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public String getConAdd1() {
        return conAdd1;
    }

    public String getConAdd2() {
        return conAdd2;
    }

    public String getConAdd3() {
        return conAdd3;
    }

    public String getConCity() {
        return conCity;
    }

    public String getConState() {
        return conState;
    }

    public String getDesPin() {
        return desPin;
    }

    public String getWt() {
        return wt;
    }

    public void setWt(String wt) {
        this.wt = wt;
    }

    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getVenCode() {
        return venCode;
    }
}
