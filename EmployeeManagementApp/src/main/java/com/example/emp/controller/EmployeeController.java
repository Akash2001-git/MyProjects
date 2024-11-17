package com.example.emp.controller;

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

import com.example.emp.entity.Employee;
import com.example.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService serve;
	
	// Rest API to create new Employee Details
		@PostMapping("/save")
		public ResponseEntity<Employee> create(@RequestBody Employee emp) {
			Employee createemp=serve.createEmp(emp);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(createemp); 
		}
		
		// Rest API to get All the Employee Details
		@GetMapping("/all")
		public List<Employee> allAccs(){
			List<Employee>allemps=serve.getAllEmployees();
			return allemps;
		}
		
		// Rest API to get anyone Employee Details
		@GetMapping("/getemp/{id}")
		public Employee getEmp(@PathVariable int id) {
			Employee getemp=serve.getEmployee(id);
			return getemp;
		}
		
		// Rest API to Update anyone of Employee Details
		@PutMapping("/update/{id}")
		public Employee updateEmp(@PathVariable int id,@RequestBody Employee emp) {
			Employee upd=serve.updateEmployee(emp, id);
			return upd;
		}
		
		// Rest API to Delete the Employee Details
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<String>deleteemp(@PathVariable Integer id){
			serve.deleteEmployee(id);
			return ResponseEntity.ok("EMLOYEE DETAILS DELETED SUCCESSFULLY!!!");
		}
		
}
