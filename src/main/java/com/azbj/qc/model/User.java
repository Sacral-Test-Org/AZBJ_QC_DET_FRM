package com.azbj.qc.model;

public class User {
    private String supervisorID;
    private String password;

    public User() {}

    public User(String supervisorID, String password) {
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
