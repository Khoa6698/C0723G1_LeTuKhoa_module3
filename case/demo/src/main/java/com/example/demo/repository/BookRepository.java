package com.example.demo.repository;

import com.example.demo.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private static final String SEARCH_ADVANCED = "select book_id, book_name, publish_year, image, author_name, book_type_name, book_quantity\n" +
            "from book b join author a on b.author_id = a.author_id\n" +
            "join book_type bt on b.book_type_id = bt.book_type_id\n" +
            "where (b.book_name like ?) or (a.author_name like ?)";

    @Override
    public List<Book> searchAdvanced(String name) {
        Connection connection = DataRepository.getConnection();
        List<Book> list = new ArrayList<>();
        Book book = null;
        try {
            PreparedStatement preparedStatement =connection.prepareStatement(SEARCH_ADVANCED);
            preparedStatement.setString(1,"%"+name+"%");
            preparedStatement.setString(2,"%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("book_id");
                String nameBook = resultSet.getString("book_name");
                String publishYear = resultSet.getString("publish_year");
                String image = resultSet.getString("image");
                String authorName = resultSet.getString("author_name");
                String bookType = resultSet.getString("book_type_name");
                int bookQuantity = resultSet.getInt("book_quantity");
                book = new Book(id,nameBook,publishYear,image,authorName,bookType,bookQuantity);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
