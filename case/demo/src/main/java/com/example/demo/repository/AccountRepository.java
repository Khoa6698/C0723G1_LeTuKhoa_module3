package com.example.demo.repository;

import com.example.demo.model.Account;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRepository implements IAccountRepository {
    private static final String SELECT_BY_ID = "select * from account where id_account = ?";

    @Override
    public Account findById(int id) {
        Connection connection = DataRepository.getConnection();
        Account account = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                int account_id = resultSet.getInt("id_account");
                String name = resultSet.getString("username");
                String password = resultSet.getString("password");
                String type = resultSet.getString("type_account");
                account = new Account(account_id,name,password,type);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }
}
