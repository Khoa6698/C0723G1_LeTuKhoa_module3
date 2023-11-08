package com.example.demo.model;

import java.util.Date;

public class EmployeeDOT {
    private int id;
    private String name;
    private String birthDay;
    private String phone;
    private String image;
    private int accountId;

    public EmployeeDOT(int id, String name, String birthDay, String phone, String image, int accountId) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.image = image;
        this.accountId = accountId;
    }

    public EmployeeDOT(String name, String birthDay, String phone, int accountId) {
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.accountId = accountId;
    }

    public EmployeeDOT(String name, String birthDay, String phone, String image, int accountId) {
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

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
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

    @Override
    public String toString() {
        return "EmployeeDOT{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDay='" + birthDay + '\'' +
                ", phone='" + phone + '\'' +
                ", image='" + image + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
