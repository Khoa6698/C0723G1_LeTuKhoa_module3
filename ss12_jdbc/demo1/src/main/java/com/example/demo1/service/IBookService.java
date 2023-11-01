package com.example.demo1.service;

import com.example.demo1.model.Book;
import com.example.demo1.model.BookDOT;

import java.util.List;

public interface IBookService {
    List<Book> showList();
    boolean create(BookDOT bookDOT);
    void delete(int id);
}
