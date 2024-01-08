package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import com.example.user.domain.ProductReviewVO;

public interface ProductReviewDAO {
	public List<HashMap<String, Object>> list(ProductReviewVO vo);
	public int total(ProductReviewVO vo);
	public List<HashMap<String, Object>> image(ProductReviewVO vo);
	public void insert(ProductReviewVO vo);
}
