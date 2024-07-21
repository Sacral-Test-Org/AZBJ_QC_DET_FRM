package com.azbj.qc.dto;

public class QCUpdateDTO {
    private String ci;
    private Integer flg;

    public QCUpdateDTO() {}

    public QCUpdateDTO(String ci, Integer flg) {
        this.ci = ci;
        this.flg = flg;
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
}
