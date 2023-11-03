package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.repository.IEmployeeRepository;

import java.util.List;

public class EmployeeService implements IEmployeeService{
    private IEmployeeRepository employeeRepository = new EmployeeRepository();
    @Override
    public List<Employee> listEmp() {
        return employeeRepository.listEmp();
    }

    @Override
    public Boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }
}
