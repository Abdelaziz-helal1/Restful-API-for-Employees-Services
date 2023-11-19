package com.abdelaziz.restfulApi.controller;

import com.abdelaziz.restfulApi.entity.Employee;
import com.abdelaziz.restfulApi.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeServices employeeServices ;

    @Autowired
    public EmployeeController(EmployeeServices employeeServices) {
        this.employeeServices = employeeServices;
    }

    // create a new employee REST API :
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
    {
        return new  ResponseEntity<Employee>(employeeServices.saveEmployee(employee), HttpStatus.CREATED);

    }

    // get all employees REST API:
    @GetMapping
    public List<Employee> getEmployee()
    {
        return employeeServices.getEmployees();
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeId)
    {
      return new ResponseEntity<Employee>(employeeServices.getEmployeeById(employeeId),HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee ,
                                                   @PathVariable("id") long theId)
    {
        return new ResponseEntity<Employee>(employeeServices.updateEmployee(employee,theId),
                HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long theId)
    {
        employeeServices.deleteById(theId);

       return new ResponseEntity<String>("Employee with id: "+ theId +", has been deleted",
               HttpStatus.OK);
    }
}
