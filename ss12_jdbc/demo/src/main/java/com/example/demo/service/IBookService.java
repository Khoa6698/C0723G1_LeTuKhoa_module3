package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.model.BookDOT;

import java.util.List;

public interface IBookService {
    List<Book> fillAll();
    boolean delete(int id);

    boolean save(BookDOT bookDOT);
}
