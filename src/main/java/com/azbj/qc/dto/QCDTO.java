package com.azbj.qc.dto;

public class QCDTO {
    private String selection;
    private Flags flags;
    private String errorCategory;
    private String contractId;
    private boolean topIndicator;

    // Getters and Setters
    public String getSelection() {
        return selection;
    }

    public void setSelection(String selection) {
        this.selection = selection;
    }

    public Flags getFlags() {
        return flags;
    }

    public void setFlags(Flags flags) {
        this.flags = flags;
    }

    public String getErrorCategory() {
        return errorCategory;
    }

    public void setErrorCategory(String errorCategory) {
        this.errorCategory = errorCategory;
    }

    public String getContractId() {
        return contractId;
    }

    public void setContractId(String contractId) {
        this.contractId = contractId;
    }

    public boolean isTopIndicator() {
        return topIndicator;
    }

    public void setTopIndicator(boolean topIndicator) {
        this.topIndicator = topIndicator;
    }

    // Inner Flags class
    public static class Flags {
        private boolean specificFlag1;
        private boolean specificFlag2;
        private boolean specificFlag3;

        // Getters and Setters
        public boolean isSpecificFlag1() {
            return specificFlag1;
        }

        public void setSpecificFlag1(boolean specificFlag1) {
            this.specificFlag1 = specificFlag1;
        }

        public boolean isSpecificFlag2() {
            return specificFlag2;
        }

        public void setSpecificFlag2(boolean specificFlag2) {
            this.specificFlag2 = specificFlag2;
        }

        public boolean isSpecificFlag3() {
            return specificFlag3;
        }

        public void setSpecificFlag3(boolean specificFlag3) {
            this.specificFlag3 = specificFlag3;
        }
    }
}