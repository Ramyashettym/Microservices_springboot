package com.example.demo.ProductService.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class product {
	
	@Column
	private String productname ;
	
	@Column
	private String price ;
	

}
