package com.example.springdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdb.entity.Employee;
import com.example.springdb.service.EmployeeService;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

	@Autowired
	EmployeeService serve;
	
	// Rest API to create new Employee Details
	@PostMapping("/save")
	public Employee saveEmp(@RequestBody Employee emp) {
		return serve.createEmp(emp);
	}
	
	// Rest API to get All the Employee Details
	@GetMapping("/getemps")
	public List<Employee>getEmps(){
		return serve.getAllEmployees();
	}
	
	// Rest API to get anyone Employee Details
	@GetMapping("/getemp/{id}")
	public Employee getEmp(@PathVariable int id) {
		return serve.getEmployee(id);
	}
	
	// Rest API to Update anyone of Employee Details
	@PutMapping("/update/{id}")
	public Employee updateEmp(@PathVariable int id,@RequestBody Employee emp) {
		return serve.updateEmployee(emp,id);
	}
	
	// Rest API to Delete the Employee Details
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String>deleteEmp(@PathVariable int id){
		 serve.deleteEmployee(id);
		 return new ResponseEntity<String>("Employee deleted Successfully", HttpStatus.OK);
	}
}








