package com.example.demo.model;

import java.util.Date;

public class EmployeeDOT {
    private int id;
    private String name;
    private Date birthDay;
    private String phone;
    private String image;
    private int accountId;

    public EmployeeDOT(int id, String name, Date birthDay, String phone, String image, int accountId) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.image = image;
        this.accountId = accountId;
    }

    public EmployeeDOT(String name, Date birthDay, String phone, String image, int accountId) {
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.image = image;
        this.accountId = accountId;
    }

    public EmployeeDOT() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
