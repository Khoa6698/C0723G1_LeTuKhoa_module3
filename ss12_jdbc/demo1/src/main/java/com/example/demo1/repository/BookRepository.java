package com.example.demo1.repository;

import com.example.demo1.model.Book;
import com.example.demo1.model.BookDOT;
import com.example.demo1.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {
    private ICategoryRepository iCategoryRepository = new CategoryRepository();
    private static final String SELECT_ALL_BOOK = "select * from books";
    private static final String DELETE_BY_ID = "delete from books where id = ?";
    private static final String ADD_BOOK = "insert into books(title,page_size,author_id,category_id) values(?,?,?,?);";

    @Override
    public List<Book> showList() {
        Connection connection = Database.getConnection();
        List<Book> bookList = new ArrayList<>();
        Book book;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_BOOK);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int pageSize = resultSet.getInt("page_size");
                int author = resultSet.getInt("authors_id");
                Category category = iCategoryRepository.findById(resultSet.getInt("category_id"));
                book = new Book(id, title, pageSize, author, category);
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookList;
    }

    @Override
    public boolean create(BookDOT bookDOT) {
        Connection connection = Database.getConnection();
        int count = 0;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BOOK);
            preparedStatement.setString(1, bookDOT.getName());
            preparedStatement.setInt(2, bookDOT.getPageSize());
            preparedStatement.setInt(3, bookDOT.getAuthor());
            preparedStatement.setInt(4, bookDOT.getCategoryId());
            count = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (count==1);
    }

    @Override
    public void delete(int id) {
        Connection connection = Database.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BY_ID);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
