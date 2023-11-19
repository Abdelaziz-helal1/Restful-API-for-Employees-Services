package com.abdelaziz.restfulApi.services;

import com.abdelaziz.restfulApi.entity.Employee;
import com.abdelaziz.restfulApi.exception.ResourceNotFoundException;
import com.abdelaziz.restfulApi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServicesImpl implements EmployeeServices {

    private EmployeeRepository employeeRepository ;
    @Autowired
    public EmployeeServicesImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(long theId) {

        return employeeRepository.findById(theId).orElseThrow(()->
                new ResourceNotFoundException("Employee","ID",theId));

    }

    @Override
    public Employee updateEmployee(Employee employee, long id) {

        // we need to check whether employee with given id is existed in Database or not:
        Employee tempEmployee = employeeRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Employee","ID",id));

        tempEmployee.setFirstName(employee.getFirstName());
        tempEmployee.setLastName(employee.getLastName());
        tempEmployee.setEmail(employee.getEmail());
        tempEmployee.setPhoneNumber(employee.getPhoneNumber());

        // saving the new information to the database:
        employeeRepository.save(tempEmployee);
        return tempEmployee ;
    }

    @Override
    public void deleteById(long theId) {

        // we need to check whether employee with given id is existed in Database or not:
        Employee tempEmployee = employeeRepository.findById(theId).orElseThrow(()->
                new ResourceNotFoundException("Employee","ID",theId));

        employeeRepository.deleteById(theId);
    }

}
