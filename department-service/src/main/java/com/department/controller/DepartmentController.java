package com.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.department.client.EmployeeClient;
import com.department.model.Department;
import com.department.repository.DepartmentRepository;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentRepository repo;
	
	@Autowired
	private EmployeeClient employeeClient;
	
	@GetMapping
	public List<Department> findAll(){
		return repo.getAll();
	}
	
	@GetMapping("/{id}")
	public Department findById(@PathVariable Long id) {
		return repo.findById(id);
	}
	
	@PostMapping
	public Department add(@RequestBody Department department) {
		return repo.addDepartment(department);
	}
	
	@GetMapping("/with-employees")
    public List<Department> findAllWithEmployees() {
        LOGGER.info("Department find");
        List<Department> departments
                = repo.getAll();
        departments.forEach(department ->
                department.setEmployeeList(
                        employeeClient.findByDepartment(department.getId())));
        return  departments;
    }
}
