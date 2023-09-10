package com.department.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Department {
	
	private Long id;
	private String name;
	private List<Employee> employeeList = new ArrayList<>();
	
	public Department() {
	}

	public Department(Long id, String name, List<Employee> employeeList) {
		this.id = id;
		this.name = name;
		this.employeeList = employeeList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", employeeList=" + employeeList + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(employeeList, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		return Objects.equals(employeeList, other.employeeList) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}
	
}
