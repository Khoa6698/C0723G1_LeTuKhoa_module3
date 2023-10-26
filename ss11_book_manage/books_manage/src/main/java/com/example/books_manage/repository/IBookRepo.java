package com.example.books_manage.repository;

import com.example.books_manage.model.Book;

import java.util.List;

public interface IBookRepo {
    List<Book> findAll();
    void newBook(Book book);
    void updateBook(Book book);
    void deleteBook(int id);
    Book findByTitle(String title);
    Book findById(int id);
}
