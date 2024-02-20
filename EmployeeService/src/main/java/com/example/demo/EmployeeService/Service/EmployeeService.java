package com.example.demo.EmployeeService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.EmployeeService.Entity.Employee;
import com.example.demo.EmployeeService.Repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	public List<Employee> getEmpNameByRole(String role){
		
		return employeeRepo.findByRole(role);
	}
	
	public Employee addEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
	}
	
	public List<Employee> getEmpNameById(String empId) {
		
		return employeeRepo.findByEmpId(empId);
	}
	
	public List<Employee> getEmpNameByEmpDept(String empdept){
		
		return employeeRepo.findByEmpdept(empdept);
	}
	
}
