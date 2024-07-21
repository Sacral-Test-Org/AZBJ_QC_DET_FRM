package com.azbj.qc.dto;

public class UserDTO {
    private String supervisorID;
    private String password;

    public UserDTO() {}

    public UserDTO(String supervisorID, String password) {
        this.supervisorID = supervisorID;
        this.password = password;
    }

    public String getSupervisorID() {
        return supervisorID;
    }

    public void setSupervisorID(String supervisorID) {
        this.supervisorID = supervisorID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
