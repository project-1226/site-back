package com.example.community.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.community.dao.CommunityDAO;
import com.example.community.domain.PostVO;

@RestController
@RequestMapping("/community")
public class CommunityRestController {

	@Autowired
	CommunityDAO dao;
	
	@GetMapping("/list/{categoryid}")
	public List<HashMap<String, Object>> list(@PathVariable("categoryid") int categoryid){
		return dao.list(categoryid);
	}
	
	@GetMapping("/read")
	public List<HashMap<String, Object>> read(int postid){
		return dao.read(postid);
	}
	
	@PostMapping("/insert")
	public void insert_post(PostVO vo) {
		dao.insert_post(vo);
	}
	
	@PostMapping("/update")
	public void update_post(PostVO vo) {
		dao.update_post(vo);
	}
	
	
}
