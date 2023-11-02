package com.example.demo.model;

public class BookDOT {
    private int id;
    private String title;
    private int pageSize;
    private int author;
    private int category;

    public BookDOT(int id, String title, int pageSize, int author, int category) {
        this.id = id;
        this.title = title;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public BookDOT(String title, int pageSize, int author, int category) {
        this.title = title;
        this.pageSize = pageSize;
        this.author = author;
        this.category = category;
    }

    public BookDOT() {
    }

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

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }
}
