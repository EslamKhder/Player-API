package com.spring.playerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


// http://localhost:8080/spring-crm-rest
@RestController
@RequestMapping("/api")
// http://localhost:8080/spring-crm-rest/api
public class PlayerController {
	
	@GetMapping("/data")
	// http://localhost:8080/spring-crm-rest/api/data
	public String getData() {
		return "mydata";
	}
	
}
