package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private IAccountRepository accountRepository = new AccountRepository();
    private static final String SELECT_ALL = "select * from employee;";
    private static final String DELETE = "delete from employee where employee_id = ?";

    @Override
    public List<Employee> listEmp() {
        Connection connection = DataRepository.getConnection();
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL);
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                Date birthDay = resultSet.getDate("date_of_birth");
                String phone = resultSet.getString("phone_number");
                String img = resultSet.getString("image");
                Account accountId = accountRepository.findById(resultSet.getInt("id_account"));
                employee = new Employee(id,name,birthDay,phone,img,accountId);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean deleteEmployee(int id) {
        Connection connection = DataRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
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
}
