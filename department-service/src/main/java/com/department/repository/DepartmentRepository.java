package com.department.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.department.model.Department;

@Repository
public class DepartmentRepository {

	private List<Department> departmentList = new ArrayList<>();
	
	public Department addDepartment(Department department) {
		departmentList.add(department);
		return department;
	}
	
	public List<Department> getAll() {
		return departmentList;
	}
	
	public Department findById(Long id) {
		
		return departmentList.stream()
			.filter(department -> department.getId().equals(id))
			.findFirst()
			.orElseThrow();
	}
}
