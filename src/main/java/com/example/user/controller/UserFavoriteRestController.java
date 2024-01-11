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

import com.example.user.dao.UserFavoriteDAO;
import com.example.user.domain.UserFavoriteVO;

@RestController
@RequestMapping("/user-favorite")
public class UserFavoriteRestController {
	@Autowired
	UserFavoriteDAO dao;
	
	@GetMapping("/list-product")
	public HashMap<String, Object> listProduct(@ModelAttribute("vo") UserFavoriteVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listProduct(vo));
		map.put("total", dao.totalProduct(vo.getUserid()));
		return map;
	}
	
	@GetMapping("/list-image")
	public List<HashMap<String, Object>> listImage(@ModelAttribute("vo") UserFavoriteVO vo) {
		return dao.listImage(vo);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestParam("favoriteid") int favoriteid) {
		dao.delete(favoriteid);
	}
}
