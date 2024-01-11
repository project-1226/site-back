package com.example.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.ProductReviewDAO;
import com.example.user.domain.ProductReviewVO;

@RestController
@RequestMapping("/product-review")
public class ProductReviewRestController {
	@Autowired
	ProductReviewDAO dao;

	@PostMapping("/insert")
	public void insert(@RequestBody ProductReviewVO vo) {
		dao.insert(vo);
	}

	@GetMapping("/list")
	public HashMap<String, Object> list(@ModelAttribute("vo") ProductReviewVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.list(vo));
		map.put("total", dao.total(vo));
		return map;
	}
	
	@GetMapping("/read")
	public HashMap<String, Object> read(@RequestParam("product_reviewid") int product_reviewid) {
		return dao.read(product_reviewid);
	}

	@GetMapping("/image")
	public List<HashMap<String, Object>> image(@RequestParam("product_reviewid") int product_reviewid) {
		return dao.image(product_reviewid);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam("product_reviewid") int product_reviewid) {
		if (dao.isImage(product_reviewid) > 0) {
			dao.deleteImage(product_reviewid);
		}
		dao.deleteReview(product_reviewid);
	}
}
