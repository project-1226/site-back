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
@RequestMapping("/user-purchase")
public class UserShopRestController {
	@Autowired
	UserShopDAO dao;

	@GetMapping("/list")
	public List<HashMap<String, Object>> list(@ModelAttribute("vo") UserShopVO vo) {
		return dao.list(vo);
	}
}
