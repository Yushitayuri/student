package com.student.bean;

public class Admin {
    private String account;
    private String password;
    private String name;
    private String situation;
    private String admin;

    public String getAccount() {
        return account;
    }
    public void setAccount(String account) {
        this.account = account;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSituation() {
        return situation;
    }
    public void setSituation(String situation) {
        this.situation = situation;
    }
    public String getAdmin() {
        return admin;
    }
    public void setAdmin(String admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", situation='" + situation + '\'' +
                ", admin='" + admin + '\'' +
                '}';
    }

    public Admin(String account, String password, String name, String situation, String admin) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.situation = situation;
        this.admin = admin;

    }
}