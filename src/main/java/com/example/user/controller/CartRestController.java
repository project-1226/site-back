package com.example.user.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.dao.CartDAO;
import com.example.user.domain.AddressVO;
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
	
	@GetMapping("/delete")  //모델어티리뷰트를 사용해서 생성자값 json 데이터 통신함 전송시 데이터를 포함시킴 await axios('/cart/delete', { cartid: product.cartid });
	public void delete(@ModelAttribute("vo") CartVO vo) {
	    dao.delete(vo);
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
	
	@PostMapping("/update/qnt")
	public void updateQnt(@RequestBody CartVO vo) {
		dao.updateQnt(vo);
	}
	
}