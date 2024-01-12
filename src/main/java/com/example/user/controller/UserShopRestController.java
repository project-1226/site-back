package com.example.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
