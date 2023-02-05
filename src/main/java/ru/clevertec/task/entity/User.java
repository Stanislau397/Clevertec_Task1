package ru.clevertec.task.entity;

public class User {

    private Long USERID;
    private String USERNAME;
    private String email;
    private String PASSWORD;

    public Long getUSERID() {
        return USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getEmail() {
        return USERNAME;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
}
