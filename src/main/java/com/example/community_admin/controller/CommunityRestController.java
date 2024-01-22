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
import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostReviewVO;
import com.example.community_admin.domain.PostVO;
import com.example.community_admin.service.CommunityService;

@RestController
@RequestMapping("/community")
public class CommunityRestController {

	@Autowired
	CommunityDAO dao;
	
	@Autowired
	CommunityService service;
	
	
	@GetMapping("/list")
	public List<HashMap<String, Object>> list(@RequestParam("categoryid") int categoryid){
		return dao.list(categoryid);
	}
	
	@GetMapping("/list_review")
	public List<HashMap<String, Object>> list_review(){
		return dao.list_review();
	}
	
	
	@GetMapping("/read")
	public HashMap<String, Object> read(@RequestParam("postid") int postid){
		return dao.read(postid);
	}
	
	@GetMapping("/read/review")
	public HashMap<String, Object> read_review(@RequestParam("postid") int postid, @RequestParam("categoryid") int categoryid){
		return dao.read_review(postid, categoryid);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody HashMap<String, Object> map) {
		dao.insert(map);
	}
	
	@PostMapping("/insert/review")
	public void insert_review(@RequestBody PostReviewVO vo) {
		dao.insert_review(vo);
	}
	
	@PostMapping("/update")
	public void update_post(@RequestBody PostVO vo) {
		dao.update_post(vo);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestParam("postid") int postid) {
		//dao.delete(postid);
		service.delete(postid);
	}
	
	
	@GetMapping("/list/comment")
	public List<HashMap<String, Object>> list_comment(){
		return dao.list_comment();
	}
	
	@PostMapping("/insert/comment")
	public void insert_comment(@RequestBody PostVO vo) {
		dao.insert_comment(vo);
	}
	
	@GetMapping("/read/comment")
	public List<HashMap<String, Object>> read_comment(@RequestParam("userid") String userid, @RequestParam("postid") int postid){
		return dao.read_comment(userid, postid);
	}
	
	@PostMapping("/update/comment")
	public void update_comment(@RequestBody HashMap<String, Object> map) {
		dao.update_comment(map);
	}
	
	@PostMapping("/delete/comment")
	public void delete_comment(@RequestParam("commentid") int commentid) {
		dao.delete_comment(commentid);
	}
	
	@GetMapping("/total/comment")
	public int total_comment(@RequestParam("postid") int postid) {
		return dao.total_comment(postid);
	}
	
	@GetMapping("/update/cnt")
	public void update_post_cnt(@RequestParam("postid") int postid) {
		dao.update_post_cnt(postid);
	}
	
	@GetMapping("/insert/commentFavorite")
	public void insert(@RequestParam("userid") String userid, @RequestParam("commentid") int commentid) {
		service.insertFavorite(userid, commentid);
	}
	
	@GetMapping("/delete/commentFavorite")
	public void delete(@RequestParam("userid") String userid, @RequestParam("commentid") int commentid) {
		service.deleteFavorite(userid, commentid);
	}
	
	@GetMapping("/image_list")
	public List<HashMap<String, Object>> image_list(@RequestParam("postid") int postid){
		return dao.image_list(postid);
	}
}
