package com.example.employee_management.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.employee_management.entity.Employee;
import com.example.employee_management.service.EmployeeService;

import jakarta.validation.Valid;




@RestController
@RequestMapping("/api/employees")
@CrossOrigin("*")

public class EmployeeController {
	
	private final EmployeeService service;

	public EmployeeController(EmployeeService service) {
		this.service = service;
	}
	
	@PostMapping
	public Employee createEmployees( @Valid @RequestBody Employee employee)
	{
		return service.saveEmployee(employee);
		
	}
	@GetMapping
	public List<Employee>getAllEmployeee()
	{
		return service.getAllEmployees();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Long id)
	{
		return service.getEmployeeById(id);
	}
	
	@PutMapping("/{id}")
	public Employee updateEmployee(@PathVariable Long id, @Valid @RequestBody Employee employee)
	{
		return service.UpdateEmployee(id, employee);
	}
	
	@DeleteMapping("/{id}")
	
	public String deleteEmployee(@PathVariable Long id)
	{
		service.deleteEmployee(id);
		return "Employee deleted successfully.";
	}

}
