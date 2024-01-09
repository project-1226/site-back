package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.user.dao.ProductReviewDAO;

@Service
public class ProductReviewServiceImpl implements ProductReviewService {
	@Autowired
	ProductReviewDAO dao;

}
