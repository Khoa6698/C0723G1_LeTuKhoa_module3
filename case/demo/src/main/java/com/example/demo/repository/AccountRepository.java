package com.example.demo.repository;

import com.example.demo.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository implements IAccountRepository {
    private static final String SELECT_BY_ID = "select * from account where id_account = ?";
    private static final String SELECT_ALL = "select * from account";

    @Override
    public Account findById(int id) {
        Connection connection = DataRepository.getConnection();
        Account account = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int account_id = resultSet.getInt("id_account");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type_account");
                account = new Account(account_id, name, password, type);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public List<Account> findAll() {
        Connection connection = DataRepository.getConnection();
        List<Account> list = new ArrayList<>();
        Account account = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()){
                int id = resultSet.getInt("id_account");
                String username = resultSet.getString("username");
                String pass = resultSet.getString("password");
                String type = resultSet.getString("type_account");
                account = new Account(id,username,pass,type);
                list.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
