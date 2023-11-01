package com.example.demo1.model;

public class Book {
    private int id;
    private String title;
    private int pageSize;
    private int author;
    private Category category;



    public Book(int id, String title, int pageSize,int author, Category category) {
        this.id = id;
        this.title = title;
        this.pageSize = pageSize;
        this.category = category;
        this.author = author;
    }

    public Book(String title, int pageSize, int author, Category category) {
        this.title = title;
        this.pageSize = pageSize;
        this.category = category;
        this.author = author;
    }

    public Book(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }
}
