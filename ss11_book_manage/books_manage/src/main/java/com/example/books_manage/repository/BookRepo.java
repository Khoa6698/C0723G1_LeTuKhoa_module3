package com.example.books_manage.repository;

import com.example.books_manage.model.Book;

import java.util.ArrayList;
import java.util.List;

public class BookRepo implements IBookRepo{
    private static List<Book> bookList;
    static {
        bookList = new ArrayList<>();
        bookList.add(new Book(1,"Toan",100,"Van Toai","Tu duy"));
        bookList.add(new Book(2,"Van",90,"Thanh","Nghe Thuat"));
        bookList.add(new Book(3,"Anh",80,"Anh Tuan","Tu duy"));
        bookList.add(new Book(4,"Ly",110,"Quyen","Tu duy"));
    }
    @Override
    public List<Book> findAll() {
        return bookList;
    }

    @Override
    public void newBook(Book book) {
        bookList.add(book);
        book.setId(bookList.size());
    }

    @Override
    public void updateBook(Book book) {
       for (Book b : bookList){
           if(b.getId()== book.getId()){
               bookList.set(bookList.indexOf(b),book);
               return;
           }
       }
    }

    @Override
    public void deleteBook(int id) {
        if(findById(id)!=null){
            bookList.remove(id);
        }
    }

    @Override
    public Book findByTitle(String title) {
        for(Book b : bookList){
            if(b.getTitle().contains(title)){
                return b;
            }
        }
        return null;
    }

    @Override
    public Book findById(int id) {
        for (Book b : bookList){
            if(b.getId()==id){
                return b;
            }
        }
        return null;
    }
}
