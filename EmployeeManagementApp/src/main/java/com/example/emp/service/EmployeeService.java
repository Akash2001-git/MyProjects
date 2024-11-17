package com.example.emp.service;

import java.util.List;

import com.example.emp.entity.Employee;

public interface EmployeeService {

	public Employee createEmp(Employee emp);
	public List<Employee>getAllEmployees();
	public Employee getEmployee(int id);
	public Employee updateEmployee(Employee emp,int id);
	public void deleteEmployee(int id);
}
