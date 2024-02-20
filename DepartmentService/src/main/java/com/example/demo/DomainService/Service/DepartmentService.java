package com.example.demo.DomainService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.DomainService.Entity.Department;
import com.example.demo.DomainService.Repo.DepartmentRepo;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo deptrepo;
	
	public Department addDepartment(Department department) {
		return deptrepo.save(department);
	}
	
	
	public Department findByDeptName(String deptname){
		
		return deptrepo.findByDeptname(deptname);
	}
	

}
