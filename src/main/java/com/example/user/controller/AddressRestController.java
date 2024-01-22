package com.example.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.AddressDAO;
import com.example.user.domain.AddressVO;
import com.example.user.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressRestController {
	@Autowired
	AddressDAO dao;
	
	@Autowired
	AddressService service;
	
	@GetMapping("/list")
	public HashMap<String, Object> list(@ModelAttribute AddressVO vo) {
		return service.list(vo);
	}
	
	@GetMapping("/read")
	public HashMap<String, Object> read(@ModelAttribute AddressVO vo) {
		return dao.read(vo);
	}
	
	@PostMapping("/insert")
	public void insert(@RequestBody AddressVO vo) {
		service.insert(vo);
	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody AddressVO vo) {
		dao.delete(vo);
	}
	
	@PostMapping("/update")
	public void update(@RequestBody AddressVO vo) {
		service.update(vo);
	}
}
