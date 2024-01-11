package com.example.community_admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.community_admin.dao.CommunityDAO;
import com.example.community_admin.domain.PostVO;

@RestController
@RequestMapping("/community")
public class CommunityRestController {

	@Autowired
	CommunityDAO dao;
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list(@RequestParam("categoryid") int categoryid){
		return dao.list(categoryid);
	}
	
	@GetMapping("/read")
	public HashMap<String, Object> read(@RequestParam("postid") int postid){
		return dao.read(postid);
	}
	
	@PostMapping("/insert")
	public void insert_post(@RequestBody PostVO vo) {
		dao.insert_post(vo);
	}
	
	@PostMapping("/update")
	public void update_post(PostVO vo) {
		dao.update_post(vo);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody int postid) {
		dao.delete(postid);
	}
	
	
	@GetMapping("/list/comment")
	public List<HashMap<String, Object>> list_comment(){
		return dao.list_comment();
	}
	
	@PostMapping("/insert/comment")
	public void insert_comment(@RequestBody String content) {
		dao.insert_comment(content);
	}
	
	@GetMapping("/read/comment")
	public List<HashMap<String, Object>> read_comment(@RequestParam("postid") int postid){
		return dao.read_comment(postid);
	}
	
	
}
