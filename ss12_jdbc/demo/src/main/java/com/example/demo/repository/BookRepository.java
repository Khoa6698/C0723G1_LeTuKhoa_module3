package com.example.demo.repository;

import com.example.demo.model.Book;
import com.example.demo.model.BookDOT;
import com.example.demo.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository{
    private ICategoryRepository categoryRepository = new CategoryRepository();
    private static final String SELECT_ALL = "select * from books";

    private static final String DELETE = "call delete_books_by_id(?);";
    private static final String ADD_BOOK = "call add_book(?,?,?,?)";
    @Override
    public List<Book> fillAll() {
        Connection connection = DataRepository.getConnection();
        List<Book> list = new ArrayList<>();
        Book book;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                int author = resultSet.getInt("authors_id");
                Category category = categoryRepository.findById(resultSet.getInt("category_id"));
                book = new Book(id,title,pageSize,author,category);
                list.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean delete(int id) {
        Connection connection = DataRepository.getConnection();
        try {
            CallableStatement callableStatement = connection.prepareCall(DELETE);
            callableStatement.setInt(1,id);
            ResultSet resultSet = callableStatement.executeQuery();
        } catch (SQLException e) {
            return false;
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    @Override
    public boolean save(BookDOT bookDOT) {
        Connection connection = DataRepository.getConnection();
        int count = 0;
        try {
            CallableStatement callableStatement = connection.prepareCall(ADD_BOOK);
            callableStatement.setString(1,bookDOT.getTitle());
            callableStatement.setInt(2,bookDOT.getPageSize());
            callableStatement.setInt(3,bookDOT.getAuthor());
            callableStatement.setInt(4,bookDOT.getCategory());
            count=callableStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (count==1);
    }
}
