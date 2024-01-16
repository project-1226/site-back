package com.example.user.controller;

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

import com.example.user.dao.UserShopDAO;
import com.example.user.domain.UserShopVO;

@RestController
@RequestMapping("/usershop")
public class UserShopRestController {
	@Autowired
	UserShopDAO dao;

	@GetMapping("/list-purchase")
	public HashMap<String, Object> listPurchase(@ModelAttribute("vo") UserShopVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listPurchase(vo));
		map.put("total", dao.total(vo.getUserid()));
		return map;
	}
	
	@GetMapping("/list-detail")
	public List<HashMap<String, Object>> listDetail(@ModelAttribute("vo") UserShopVO vo) {
		return dao.listDetail(vo);
	}
	
	@GetMapping("/read-detail")
	public List<HashMap<String, Object>> readDetail(@RequestParam("purchaseid") String purchaseid) {
		return dao.readDetail(purchaseid);
	}
	
	@PostMapping("/return/insert")
	public void insertReturn(@RequestBody UserShopVO vo) {
		dao.insertReturn(vo);
	}
	
	@GetMapping("/return/list")
	public HashMap<String, Object> listReturn(@RequestParam("userid") String userid) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.listReturn(userid));
		map.put("total", dao.countReturn(userid));
		return map;
	}
}
