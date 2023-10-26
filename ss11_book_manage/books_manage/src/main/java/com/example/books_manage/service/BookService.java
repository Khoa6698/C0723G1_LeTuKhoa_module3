package com.example.books_manage.service;

import com.example.books_manage.model.Book;
import com.example.books_manage.repository.BookRepo;
import com.example.books_manage.repository.IBookRepo;
import java.util.List;
import java.awt.*;

public class BookService implements IBookService{
    private IBookRepo bookRepo = new BookRepo();
    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    @Override
    public void newBook(Book book) {
        bookRepo.newBook(book);
    }

    @Override
    public void updateBook( Book book) {
        bookRepo.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepo.deleteBook(id);
    }

    @Override
    public Book findByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    @Override
    public Book findById(int id) {
        return bookRepo.findById(id);
    }
}
