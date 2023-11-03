package com.example.demo.repository;

import com.example.demo.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> listEmp();

    Boolean deleteEmployee(int id);
}
