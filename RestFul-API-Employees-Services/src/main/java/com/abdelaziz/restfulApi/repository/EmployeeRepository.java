package com.abdelaziz.restfulApi.repository;

import com.abdelaziz.restfulApi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee, Long> {

    // that's it .....
}
