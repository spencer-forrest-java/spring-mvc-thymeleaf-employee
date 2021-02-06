package com.spencer.forrest.employee.service;

import com.spencer.forrest.employee.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAll();
    EmployeeDTO findById(int id);
    void save(EmployeeDTO EmployeeDTO);
    void deleteById(int id);
}
