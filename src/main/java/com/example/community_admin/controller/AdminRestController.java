package com.example.community_admin.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.community_admin.dao.AdminDAO;
import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductSearch;
import com.example.community_admin.domain.ProductVO;
import com.example.community_admin.domain.QueryVO;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	AdminDAO dao;
	
	@PostMapping("/insert")
	public void insert(@RequestBody PostVO vo) {
		dao.insert(vo);
	}
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list(@RequestParam("categoryid") int categoryid) {
		return dao.list(categoryid);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody PostVO vo) {
		dao.update(vo);
	}
	
	@GetMapping("/userlist")
	public List<HashMap<String, Object>> userList() {
		return dao.userList();
	}
	
	@GetMapping("/product/list")
	public String listJson(QueryVO vo) {
		return ProductSearch.main(vo);
	}
	
	@PostMapping("/insert/product")
	public void insert(@RequestBody ProductVO vo) {
		//vo.getName()
		vo.setContent("");
		dao.insertProduct(vo);
	}
	
	@PostMapping("/insertProR")
	public void insertProR(@RequestBody HashMap<String, Object> map) {
		System.out.println("=======================");
		System.out.println(map);
		dao.insertProR(map);
	}
	
	
}
