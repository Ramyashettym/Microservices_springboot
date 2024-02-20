package com.example.demo.DomainService.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.DomainService.Entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer> {
	
  public Department findByDeptname(String deptname);

}
