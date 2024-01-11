package com.example.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.ShoppingQnaDAO;

@RestController
@RequestMapping("/shoppingqna")
public class ShoppingQnaRestController {
	@Autowired
	ShoppingQnaDAO dao;
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list(@RequestParam("categoryid") int categoryid) {
		return dao.list(categoryid);
	}
}
