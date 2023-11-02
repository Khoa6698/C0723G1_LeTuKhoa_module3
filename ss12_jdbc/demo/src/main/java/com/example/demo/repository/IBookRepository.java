package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookDOT;

import java.util.List;

public interface IBookRepository {
    List<Book> fillAll();
    boolean delete(int id);

    boolean save(BookDOT bookDOT);
}
