package com.azbj.qc.dto;

public class VendorDTO {
    private String vendorCode;
    private String vendorName;

    public VendorDTO() {}

    public VendorDTO(String vendorCode, String vendorName) {
        this.vendorCode = vendorCode;
        this.vendorName = vendorName;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }
}
