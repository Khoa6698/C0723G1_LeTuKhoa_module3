package com.example.demo.repository;

import com.example.demo.model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository {
    private static final String FIND_BY_ID = "select * from category where id = ?";
    private static final String SELECT_ALL = "select * from category;";
    @Override
    public Category findById(int id) {
        Connection connection = DataRepository.getConnection();
        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int categoryId = resultSet.getInt("id");
                String name = resultSet.getString("name");
                category = new Category(categoryId,name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public List<Category> showList() {
        Connection connection = DataRepository.getConnection();
        List<Category> list = new ArrayList<>();
        Category category;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
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
