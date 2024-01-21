package com.example.community_admin.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.community_admin.dao.AdminDAO;
import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductSearch;
import com.example.community_admin.domain.ProductVO;
import com.example.community_admin.domain.QueryVO;
import com.example.community_admin.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
	
	@Autowired
	AdminDAO dao;
	
	@Autowired
	AdminService service;
	
	
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
	
	@PostMapping("/deletePost")
	public void deletePost(@RequestParam("postid") int postid) {
		dao.deletePost(postid);
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
		vo.setContent("");
		//dao.insertProduct(vo);
		service.insertProduct(vo);
	}
	
	@PostMapping("/insertProR")
	public void insertProR(@RequestBody HashMap<String, Object> map) {
		System.out.println("=======================");
		System.out.println(map);
		dao.insertProR(map);
	}
	
	@PostMapping("/deleteProduct")
	public void deleteProduct(@RequestBody ProductVO vo) {
		int productid = vo.getProductid();
		service.deleteProduct(productid);
	}
	
	@GetMapping("/productList")
	public List<HashMap<String, Object>> productList(@ModelAttribute QueryVO vo) {
		return dao.productList(vo);
	}
	
	@GetMapping("/total")
	public int total(@ModelAttribute QueryVO vo) {
		return dao.total(vo);
	}
	
	@GetMapping("/imageList")
	public List<HashMap<String, Object>> imageList(@RequestParam("productid") int productid) {
		return dao.imageList(productid);
	}
	
	@GetMapping("/qnaList")
	public List<HashMap<String, Object>> qnaList(@RequestParam("userid") String userid) {
		return dao.qnaList(userid);
	}
	
	@PostMapping("/insertQnaComment")
	public void insertQnaComment(@RequestBody CommentVO vo) {
		dao.insertQnaComment(vo);
	}
	
	@GetMapping("/orderList")
	public List<HashMap<String, Object>> orderList() {
		return dao.orderList();
	}
}
