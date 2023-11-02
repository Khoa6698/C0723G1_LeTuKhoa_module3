package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookDOT;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService{
    private IBookRepository bookRepository = new BookRepository();
    @Override
    public List<Book> fillAll() {
        return bookRepository.fillAll();
    }

    @Override
    public boolean delete(int id) {
        return bookRepository.delete(id);
    }

    @Override
    public boolean save(BookDOT bookDOT) {
        return bookRepository.save(bookDOT);
    }
}
