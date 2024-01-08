package com.example.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.ProductReviewDAO;
import com.example.user.domain.ProductReviewVO;

@RestController
@RequestMapping("/product_review")
public class ProductReviewRestController {
	@Autowired
	ProductReviewDAO dao;
	
	@PostMapping("/insert")
	public void insert(@RequestBody ProductReviewVO vo) {
		dao.insert(vo);
	}
}
