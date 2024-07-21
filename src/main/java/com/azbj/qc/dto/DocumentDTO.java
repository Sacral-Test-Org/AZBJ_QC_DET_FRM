package com.azbj.qc.dto;

public class DocumentDTO {
    private String filePath;

    public DocumentDTO() {}

    public DocumentDTO(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}