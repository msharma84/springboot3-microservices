package com.employee.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.employee.model.Employee;

@Repository
public class EmployeeRepository {
	
	private List<Employee> employeeList = new ArrayList<>();
	
	public Employee add(Employee employee) {
		employeeList.add(employee);
		return employee;
	}
	
	public List<Employee> getAll(){
		return employeeList;
	}
	
	public Employee getById(Long id) {
		
		return employeeList.stream()
			.filter(employee -> employee.id().equals(id))
			.findFirst()
			.orElseThrow();
	}
	
	public List<Employee> findByDepartment(Long departmentId){
		return employeeList.stream()
			.filter(emp -> emp.departmentId().equals(departmentId))
			.toList();
	}
}
