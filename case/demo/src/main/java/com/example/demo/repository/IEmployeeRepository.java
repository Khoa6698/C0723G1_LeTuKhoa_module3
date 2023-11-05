package com.example.demo.repository;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDOT;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> listEmp();

    Boolean deleteEmployee(int id);
    Boolean createEmployee(EmployeeDOT employeeDOT);
    List<Employee> searchByName(String name);
    Employee findById(int id);
    void updateEmployee(EmployeeDOT employeeDOT);
}
