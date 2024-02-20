package com.example.demo.DomainService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.DomainService.Entity.Department;
import com.example.demo.DomainService.Model.Employee;
import com.example.demo.DomainService.Model.RequiredResponse;
import com.example.demo.DomainService.Service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;



@RestController
@RequestMapping("/Department")
public class DepartmentController {


	
	@Autowired
	private DepartmentService deptservice;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("/add")
	public ResponseEntity<Department> addDepartment(@RequestBody Department dept){
		
			Department newdept = deptservice.addDepartment(dept);
			return new ResponseEntity<>(newdept, HttpStatus.OK);
		
	}
	
	@GetMapping("/deptname/{deptname}")
	@HystrixCommand(fallbackMethod = "handleEmployeeDownTime")
	public ResponseEntity<RequiredResponse> getallDataBasedOndeptname(@PathVariable String deptname){
		
		RequiredResponse response = new RequiredResponse();
		
		//get department details by name
		Department deptdetail = deptservice.findByDeptName(deptname);
		response.setDept(deptdetail);
		
		//get all employees under each department
		
		List<Employee> listOfEmployee= restTemplate.getForObject("http://EMPLOYEE-SERVICE/Employee/bydept/"+deptname, List.class);
		response.setEmployees(listOfEmployee);
		
		return new ResponseEntity<RequiredResponse>(response,HttpStatus.OK);
	}
	
	
	
	public ResponseEntity<RequiredResponse> handleEmployeeDownTime(@PathVariable String deptname){
		
		RequiredResponse response = new RequiredResponse();
		Department deptdetail = deptservice.findByDeptName(deptname);
		response.setDept(deptdetail);
		
		return new ResponseEntity<RequiredResponse>(response,HttpStatus.OK);
	}

}
