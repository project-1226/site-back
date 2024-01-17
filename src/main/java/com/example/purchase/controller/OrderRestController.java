package com.example.purchase.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.dao.OrderDAO;
import com.example.purchase.domain.OrderVO;
import com.example.purchase.service.OrderService;
import com.example.user.domain.AddressVO;
import com.example.user.domain.UserVO;

@RestController
@RequestMapping("/order")

public class OrderRestController {

	@Autowired
	OrderDAO dao;
	
	@Autowired
	OrderService service;
	
	
	@GetMapping("/list.json")
	public HashMap<String,Object> list(UserVO vo){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("list", dao.listPurchase(vo));
	
		return map;
	}
	@PostMapping("/insert")
	public void insert(@RequestBody OrderVO vo) {					
		service.insert(vo);
	}
	@PostMapping("/insertpd")
	public void insertpd(@RequestBody OrderVO vo) {					
		service.insertpd(vo);
	}
	
}
