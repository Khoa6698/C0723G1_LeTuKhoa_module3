package com.example.demo.repository;

import com.example.demo.model.Account;
import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDOT;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private IAccountRepository accountRepository = new AccountRepository();
    private static final String SELECT_ALL = "select * from employee;";
    private static final String DELETE = "delete from employee where employee_id = ?";
//    private static final String NEW_EMPLOYEE = "insert into employee(employee_name, date_of_birth, phone_number,image, id_account) " +
//                                                    "values(?,?,?,?,?);";
    private static final String SEARCH_BY_NAME = "select * from employee where employee_name like ?";
    private static final String SELECT_BY_ID = "select * from employee where employee_id = ?";
    private static final String UPDATE = "update employee set employee_name = ?," +
            " date_of_birth= ?, phone_number = ?, image = ?, id_account = ? where employee_id = ? ";
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
                employee = new Employee(id, name, birthDay, phone, img, accountId);
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
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            return false;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

//    @Override
//    public Boolean createEmployee(EmployeeDOT employeeDOT) {
//        Connection connection = DataRepository.getConnection();
//        int count = 0;
//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(NEW_EMPLOYEE);
//            preparedStatement.setString(1,employeeDOT.getName());
//            preparedStatement.setString(2,employeeDOT.getBirthDay());
//            preparedStatement.setString(3,employeeDOT.getPhone());
//            preparedStatement.setString(4,employeeDOT.getImage());
//            preparedStatement.setInt(5,employeeDOT.getAccountId());
//            count = preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return (count==1);
//    }

    @Override
    public List<Employee> searchByName(String name) {
        Connection connection = DataRepository.getConnection();
        List<Employee> list = new ArrayList<>();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_BY_NAME);
            preparedStatement.setString(1, "%"+name+"%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("employee_id");
                String nameEmp = resultSet.getString("employee_name");
                Date birthDay = resultSet.getDate("date_of_birth");
                String phone =resultSet.getString("phone_number");
                String image = resultSet.getString("image");
                Account account = accountRepository.findById(resultSet.getInt("id_account"));
                employee = new Employee(id,nameEmp,birthDay,phone,image,account);
                list.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Employee findById(int id) {
        Connection connection = DataRepository.getConnection();
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int employeeId = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                Date birthDay = resultSet.getDate("date_of_birth");
                String phone = resultSet.getString("phone_number");
                String img = resultSet.getString("image");
                Account account = accountRepository.findById(resultSet.getInt("id_account"));
                employee = new Employee(employeeId,name,birthDay,phone,img,account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public void updateEmployee(EmployeeDOT employeeDOT) {
        Connection connection = DataRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE);
            preparedStatement.setString(1,employeeDOT.getName());
            preparedStatement.setString(2, employeeDOT.getBirthDay());
            preparedStatement.setString(3,employeeDOT.getPhone());
            preparedStatement.setString(4,employeeDOT.getImage());
            preparedStatement.setInt(5,employeeDOT.getAccountId());
            preparedStatement.setInt(6,employeeDOT.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
