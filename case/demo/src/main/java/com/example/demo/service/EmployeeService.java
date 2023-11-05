package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeDOT;
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

    @Override
    public Boolean createEmployee(EmployeeDOT employeeDOT) {
        return employeeRepository.createEmployee(employeeDOT);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return employeeRepository.searchByName(name);
    }

    @Override
    public Employee findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void updateEmployee(EmployeeDOT employeeDOT) {
        employeeRepository.updateEmployee(employeeDOT);
    }
}
