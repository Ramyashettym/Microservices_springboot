package com.example.demo.EmployeeService.Controller;


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

import com.example.demo.EmployeeService.Entity.Employee;
import com.example.demo.EmployeeService.Service.EmployeeService;

@RestController
@RequestMapping("/Employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/test")
	public ResponseEntity<String> test(){
		return new ResponseEntity<>("hello", HttpStatus.OK);
	}
	
	
	@GetMapping("/byRole/{role}")
	public ResponseEntity<List<Employee>> getEmpNamesByRole(@PathVariable String role ){
		
			List<Employee> employees = empservice.getEmpNameByRole(role);
			return new  ResponseEntity<>(employees, HttpStatus.OK);
		//return new ResponseEntity<>(List<Employee>, HttpStatus.OK);
		
		
	}
	
	@GetMapping("/bydept/{empdept}")
	public ResponseEntity<List<Employee>> getEmpNamesByEmpDept(@PathVariable String empdept ){
		
			List<Employee> employees = empservice.getEmpNameByEmpDept(empdept);
			return new  ResponseEntity<>(employees, HttpStatus.OK);
		//return new ResponseEntity<>(List<Employee>, HttpStatus.OK);
		
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee nemployee){
		
			Employee newemployee = empservice.addEmployee(nemployee);
			return new ResponseEntity<>(newemployee, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/empId/{empId}")
	public ResponseEntity<List<Employee>> getEmployeeByID(@PathVariable String empId){
		
		List<Employee> employees = empservice.getEmpNameById(empId);
		return new ResponseEntity<>(employees, HttpStatus.OK);

	}
		
	

}
