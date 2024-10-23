package com.example.springdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdb.entity.Employee;
import com.example.springdb.repository.EmployeeRepository;

@Service
public class EmployeeService {

	// CREATE,GETALL EMPS,GET EMP BY ID, DELETE,UPDATE EMP DETAILS
	
	
	@Autowired
	EmployeeRepository repo;
	public Employee createEmp(Employee emp) {
		return repo.save(emp);
		}
	
	public List<Employee>getAllEmployees(){
		return repo.findAll();
	}
	
	
	public Employee getEmployee(int id) {
		return repo.findById(id).orElse(null);
		}
	
	public Employee updateEmployee(Employee emp,int id) {
		Employee oldEmp=repo.findById(id).orElse(null);
		oldEmp.setId(emp.getId());
		oldEmp.setName(emp.getName());
		oldEmp.setSalary(emp.getSalary());
		oldEmp.setMail(emp.getMail());
		repo.save(oldEmp);
		return oldEmp;

	}
	
	public void deleteEmployee(int id){
		 repo.deleteById(id);
		}
}




