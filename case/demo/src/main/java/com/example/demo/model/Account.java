package com.example.demo.model;

public class Account {
    private int id;
    private String name;
    private String passWord;
    private String typeAc;

    public Account(int id, String name, String passWord, String typeAc) {
        this.id = id;
        this.name = name;
        this.passWord = passWord;
        this.typeAc = typeAc;
    }

    public Account(String name, String passWord, String typeAc) {
        this.name = name;
        this.passWord = passWord;
        this.typeAc = typeAc;
    }

    public Account() {
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

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getTypeAc() {
        return typeAc;
    }

    public void setTypeAc(String typeAc) {
        this.typeAc = typeAc;
    }
}
