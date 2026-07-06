package com.example.employee_management.service;

import java.util.List;

import com.example.employee_management.entity.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	Employee getEmployeeById(Long id);
	Employee UpdateEmployee(Long id, Employee employee);
	void deleteEmployee(Long id);
	
	List<Employee> getAllEmployees();
}
