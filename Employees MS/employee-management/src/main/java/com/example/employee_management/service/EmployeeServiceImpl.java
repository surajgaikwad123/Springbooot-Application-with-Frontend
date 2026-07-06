package com.example.employee_management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService
{

    private final EmployeeRepository repository;
	public EmployeeServiceImpl(EmployeeRepository repository)
	{
		this.repository = repository;
	}
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return repository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return repository.findAll();
		}
	@Override
	public Employee getEmployeeById(Long id) { 
		 return repository.findById(id)
				 .orElseThrow(() -> new RuntimeException("Employee not found"));
		 }
	public Employee UpdateEmployee(Long id, Employee employee)
	{
		Employee exixtingEmployee = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));

		exixtingEmployee.setFirstName(employee.getFirstName());
		exixtingEmployee.setLastName(employee.getLastName());
		exixtingEmployee.setEmail(employee.getEmail());
		return repository.save(exixtingEmployee);
		
	}
	@Override
	public void deleteEmployee(Long id) {
		
		Employee employee = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Employee not found"));
		
		repository.delete(employee);
	}
	
}
