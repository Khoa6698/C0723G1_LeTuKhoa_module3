package com.example.demo1.model;

public class BookDOT {
    private int id;
    private String name;
    private int pageSize;
    private int author;
    private int categoryId;


    public BookDOT(String name, int pageSize,int author, int categoryId) {
        this.name = name;
        this.pageSize = pageSize;
        this.author = author;
        this.categoryId = categoryId;
    }
    public BookDOT(int id,String name, int pageSize,int author, int categoryId) {
        this.id = id;
        this.name = name;
        this.pageSize = pageSize;
        this.author = author;
        this.categoryId = categoryId;
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

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
