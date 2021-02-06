package com.spencer.forrest.employee.repository;

import com.spencer.forrest.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
}
