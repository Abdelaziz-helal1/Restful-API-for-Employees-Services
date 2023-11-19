package com.abdelaziz.restfulApi.services;

import com.abdelaziz.restfulApi.entity.Employee;
import com.abdelaziz.restfulApi.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeServices {

    Employee saveEmployee(Employee employee);

    List<Employee> getEmployees() ;

    Employee getEmployeeById(long theId);

    Employee updateEmployee(Employee tempEmployee, long id);

    void deleteById(long theId) ;
}
