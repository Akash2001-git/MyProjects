package com.example.emp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.emp.entity.Employee;
import com.example.emp.repository.EmployeeRepo;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepo repo;
	
	
	public Employee createEmp(Employee emp) {
		Employee create=repo.save(emp);
		return create;
	}

	
	public List<Employee> getAllEmployees() {
		List<Employee>ListofAcc=repo.findAll();
		return ListofAcc;
		
	}

	
	public Employee getEmployee(int id) {
		Optional <Employee>employee=repo.findById(id);
		if(employee.isEmpty()) {
			throw new RuntimeException("employee is not present!!!");
		}
		Employee acc=employee.get();
		return acc;
	}

	
	public Employee updateEmployee(Employee emp, int id) {
		Employee oldEmp=repo.findById(id).orElse(null);
		oldEmp.setId(emp.getId());
		oldEmp.setName(emp.getName());
		oldEmp.setSalary(emp.getSalary());
		oldEmp.setMail(emp.getMail());
		repo.save(oldEmp);
		return oldEmp;
		
	}

	
	public void deleteEmployee(int id) {
		repo.deleteById(id);
		
	}

}
