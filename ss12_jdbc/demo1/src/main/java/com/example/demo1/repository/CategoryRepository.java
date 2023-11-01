package com.example.demo1.repository;

import com.example.demo1.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
 private static final String FIND_CATEGORY_BY_ID = "select * from category where id = ?";
 private static final String FIND_ALL = "select * from category";
    @Override
    public Category findById(int id) {
        Connection connection = Database.getConnection();
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_CATEGORY_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int categoryID = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(categoryID,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> showList() {
        Connection connection = Database.getConnection();
        List<Category> list = new ArrayList<>();
        Category category = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(id,name);
                list.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
