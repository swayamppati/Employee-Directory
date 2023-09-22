package com.swayampp.springmvccrud.employee.service;

import com.swayampp.springmvccrud.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //Declare the methods
    List<Employee> findAll();

    void save(Employee employee);

    Employee findById(int id);

    void deleteById(int id);
}
