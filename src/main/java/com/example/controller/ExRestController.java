package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.ExDAO;

@RestController
public class ExRestController {
	@Autowired
	ExDAO dao;
	
	@GetMapping("/now")
	public String now() {
		return dao.now();
	}
}
