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

import com.example.survey.AnswerVO;
import com.example.survey.SurvetInsertDTO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.UserVO;
import com.example.user.service.UserService;

@RestController
@RequestMapping("user")
public class UserRestController {
	@Autowired
	UserDAO dao;
	
	@Autowired
	UserService service;
	
	@GetMapping("/read")
	public HashMap<String, Object> read(@ModelAttribute("vo") UserVO vo) {
		return dao.read(vo);
	}
	
	
	@PostMapping("/insert")
	public void insert(@RequestBody SurvetInsertDTO requestData) {
		//System.out.println(requestData); //System.out.println(requestData.getClass().getTypeName());
				
		service.insert(requestData); // 회원가입+설문저장 SurvetInsertDTO (UserVO us + List<AnswerVO> result)
	}
	
	@PostMapping("/login")
	public HashMap<String, Object> login(@RequestBody UserVO vo) {
		int result = 0; // 아이디가 없는 경우
		HashMap<String, Object> user = dao.read(vo);
		if(user != null ) {
			if(!vo.getPassword().equals(user.get("password"))) {
				result = 2; // 비밀번호 불일치
			} else {
				result = 1; // 아이디 비밀번호 일치
			}
		}
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("result", result);
		map.put("user", user);
		return map;
	}
	
	@PostMapping("/update")
	public void update(@RequestBody UserVO vo) {
		dao.update(vo);
	}
	
	@GetMapping("/survey/read")
	public List<HashMap<String, Object>> readUserSurvey(@RequestParam("userid") String userid) {
		return dao.readUserSurvey(userid);
	}
	
	@PostMapping("/survey/change")
	public void changeUserSurvey(@RequestBody UserVO vo) {
		service.changeUserSurvey(vo);
	}
	
	@GetMapping("/list-allergy")
	public List<HashMap<String, Object>> listAllergy() {
		return dao.listAllergy();
	}

}
