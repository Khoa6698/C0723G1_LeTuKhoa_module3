package com.example.demo.model;

public class Book {
private int id;
private String name;
private String publishYear;
private String img;
private String author;
private String bookType;
private int bookQuantity;

    public Book(int id, String name, String publishYear, String img, String author, String bookType, int bookQuantity) {
        this.id = id;
        this.name = name;
        this.publishYear = publishYear;
        this.img = img;
        this.author = author;
        this.bookType = bookType;
        this.bookQuantity = bookQuantity;
    }

    public Book() {
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

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public int getBookQuantity() {
        return bookQuantity;
    }

    public void setBookQuantity(int bookQuantity) {
        this.bookQuantity = bookQuantity;
    }
}
