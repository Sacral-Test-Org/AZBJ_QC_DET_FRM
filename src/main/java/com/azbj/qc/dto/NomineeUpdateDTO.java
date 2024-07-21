package com.azbj.qc.dto;

public class NomineeUpdateDTO {
    private String nomineeName;
    private String policyReference;

    public NomineeUpdateDTO() {}

    public NomineeUpdateDTO(String nomineeName, String policyReference) {
        this.nomineeName = nomineeName;
        this.policyReference = policyReference;
    }

    public String getNomineeName() {
        return nomineeName;
    }

    public void setNomineeName(String nomineeName) {
        this.nomineeName = nomineeName;
    }

    public String getPolicyReference() {
        return policyReference;
    }

    public void setPolicyReference(String policyReference) {
        this.policyReference = policyReference;
    }
}
