package com.example.demo.EmployeeService.Entity;



import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column
    @JsonProperty("empId")
    private String empId;

    @Column
    @JsonProperty("empname")
    private String empname;

    @Column
    @JsonProperty("empdept")
    private String empdept;

    @Column
    @JsonProperty("role")
    private String role;

}
