package com.example.springdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springdb.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

}
