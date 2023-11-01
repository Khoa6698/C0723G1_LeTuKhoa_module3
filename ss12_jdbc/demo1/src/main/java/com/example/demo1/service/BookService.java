package com.example.demo1.service;

import com.example.demo1.model.Book;
import com.example.demo1.model.BookDOT;
import com.example.demo1.repository.BookRepository;
import com.example.demo1.repository.IBookRepository;

import java.util.List;

public class BookService implements IBookService {
    private IBookRepository iBookRepository = new BookRepository();

    @Override
    public List<Book> showList() {
        return iBookRepository.showList();
    }

    @Override
    public boolean create(BookDOT bookDOT) {
         return iBookRepository.create(bookDOT);
    }

    @Override
    public void delete(int id) {
        iBookRepository.delete(id);
    }
}
