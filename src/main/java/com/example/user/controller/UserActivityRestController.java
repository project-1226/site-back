package com.example.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.UserActivityDAO;
import com.example.user.domain.UserActivityVO;

@RestController
@RequestMapping("/activity")
public class UserActivityRestController {
	@Autowired
	UserActivityDAO dao;
	
	@GetMapping("/list-post")
	public HashMap<String, Object> listPost(@ModelAttribute("vo") UserActivityVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listPost(vo));
		map.put("total", dao.totalPost(vo));
		return map;
	}
	
	@GetMapping("/total-post")
	public int totalPost(@ModelAttribute("vo") UserActivityVO vo) {
		return dao.totalPost(vo);
	}
	
	@GetMapping("/total-comment")
	public int totalComment(@ModelAttribute("vo") UserActivityVO vo) {
		return dao.totalComment(vo);
	}
	
	@GetMapping("/count-comment")
	public int countComment(@ModelAttribute("vo") UserActivityVO vo) {
		return dao.countComment(vo);
	}
	
	@GetMapping("/list-comment")
	public HashMap<String, Object> listComment(@ModelAttribute("vo") UserActivityVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listComment(vo));
		map.put("total", dao.totalComment(vo));
		return map;
	}
}
