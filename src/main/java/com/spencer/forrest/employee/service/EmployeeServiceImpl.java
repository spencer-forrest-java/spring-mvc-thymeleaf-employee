package com.spencer.forrest.employee.service;

import com.spencer.forrest.employee.dto.EmployeeDTO;
import com.spencer.forrest.employee.entity.Employee;
import com.spencer.forrest.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private final EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<EmployeeDTO> findAll() {
		return employeeRepository.findAllByOrderByLastNameAsc().stream()
														 .map(this::transformToEmployeeDTO)
														 .collect(Collectors.toList());
	}

	@Override
	public EmployeeDTO findById(int id) {
		Optional<Employee> optional = employeeRepository.findById(id);
		Employee employee = optional.orElse(null);
		if (employee == null) {
			return null;
		}
		return transformToEmployeeDTO(employee);
	}

	@Override
	public void save(EmployeeDTO employeeDTO) {
		boolean isEmpty = employeeDTO.getFirstName().trim().isEmpty()
				|| employeeDTO.getLastName().trim().isEmpty()
				|| employeeDTO.getEmail().trim().isEmpty();

		if (!isEmpty) {
			Employee employee = new Employee();
			employee.setId(employeeDTO.getId());
			employee.setFirstName(employeeDTO.getFirstName());
			employee.setLastName(employeeDTO.getLastName());
			employee.setEmail(employeeDTO.getEmail());
			employeeRepository.save(employee);
		}
	}

	@Override
	public void deleteById(int id) {
		employeeRepository.deleteById(id);
	}

	private EmployeeDTO transformToEmployeeDTO(Employee employee) {
		if (employee == null) {
			return null;
		}

		EmployeeDTO employeeDTO = new EmployeeDTO();
		employeeDTO.setId(employee.getId());
		employeeDTO.setFirstName(employee.getFirstName());
		employeeDTO.setLastName(employee.getLastName());
		employeeDTO.setEmail(employee.getEmail());

		return employeeDTO;
	}
}
