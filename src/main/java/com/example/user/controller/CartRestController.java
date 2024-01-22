package com.example.user.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.domain.OrderVO;
import com.example.user.dao.CartDAO;
import com.example.user.domain.CartVO;
import com.example.user.domain.UserVO;
import com.example.user.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartRestController {
	
	@Autowired
	CartDAO dao;
	
	@Autowired
	CartService service;
	
//	@GetMapping("/delete")  //겟일때는 리퀘스트파람으로  cartid =3 << 여기서 숫자를 사용하겠다는 의미로 리퀘스트파람을넣음 
//	public void delete(@RequestParam("cartid") int cartid) {
//	    dao.delete(cartid);
//	}
	
	@PostMapping("/delete")
	public void delete(@RequestBody CartVO vo) {

	    dao.delete(vo.getCartid());
	}


	
	@GetMapping("/list.json")
	public HashMap<String,Object> list(UserVO vo){
		HashMap<String,Object> map=new HashMap<String,Object>();
		map.put("list", dao.list(vo));
		map.put("total", dao.total(vo.getUserid()));
		map.put("sum", dao.sum(vo.getUserid()));
		return map;
	}
	
	
	@PostMapping("/insert")
	public void insert(@RequestBody CartVO vo) {
		service.insert(vo);
	}
	
	//myDiet(내식단)에서 재료담기
	@PostMapping("/insert-list")
	public int insertList(@RequestBody List<String> ingreList){
		return service.insertList(ingreList);
	}
	
	@PostMapping("/update/qnt")
	public void updateQnt(@RequestBody CartVO vo) {
		dao.updateQnt(vo);
	}
	
}