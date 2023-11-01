package com.example.demo1.repository;

import com.example.demo1.model.Book;
import com.example.demo1.model.BookDOT;

import java.util.List;

public interface IBookRepository {
    List<Book> showList();
    boolean create(BookDOT bookDOT);
    void delete(int id);
}
