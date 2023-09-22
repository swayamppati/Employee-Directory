package com.swayampp.springmvccrud.employee.dao;

import com.swayampp.springmvccrud.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //add a method to sort by last name
    public List<Employee> findAllByOrderByFirstNameAsc();
}
