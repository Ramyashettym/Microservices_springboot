package com.example.demo.EmployeeService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.EmployeeService.Entity.Employee;

@Repository
public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{
	
	public List<Employee> findByRole(String role);
	
	public List<Employee> findByEmpId(String empId);
	
	public List<Employee> findByEmpdept(String empdept);
}
