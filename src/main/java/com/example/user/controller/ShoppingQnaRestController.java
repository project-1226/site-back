package com.example.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.ShoppingQnaDAO;
import com.example.user.domain.ShoppingQnaVO;

@RestController
@RequestMapping("/shoppingqna")
public class ShoppingQnaRestController {
	@Autowired
	ShoppingQnaDAO dao;
	
	@GetMapping("/faq/list")
	public List<HashMap<String, Object>> listFaq(@RequestParam("categoryid") int categoryid) {
		return dao.listFaq(categoryid);
	}
	
	@PostMapping("/insert")
	public void insertQna(@RequestBody ShoppingQnaVO vo) {
		dao.insertQna(vo);
	}
	
	@GetMapping("/list")
	public HashMap<String, Object> listQna(@RequestParam("userid") String userid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listQna(userid));
		map.put("total", dao.totalQna(userid));
		return map;
	}
	
	@PostMapping("/delete")
	public void deleteQna(@RequestBody ShoppingQnaVO vo) {
		dao.deleteQna(vo);
	}
	
	@GetMapping("/all")
	public List<HashMap<String, Object>> listAll() {
		return dao.listAll();
	}
}
