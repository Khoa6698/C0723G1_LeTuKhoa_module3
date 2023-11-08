package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Book> searchAdvanced(String name) {
        return bookRepository.searchAdvanced(name);
    }
}
