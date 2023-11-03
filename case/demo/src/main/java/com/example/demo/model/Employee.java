package com.example.demo.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Employee {
    private int id;
    private String name;
    private Date birthDay;
    private String phone;
    private String img;
    private Account account;

    public Employee(int id, String name, Date birthDay, String phone, String img, Account account) {
        this.id = id;
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.img = img;
        this.account = account;
    }

    public Employee(String name, Date birthDay, String phone, String img, Account account) {
        this.name = name;
        this.birthDay = birthDay;
        this.phone = phone;
        this.img = img;
        this.account = account;
    }

    public Employee() {
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
