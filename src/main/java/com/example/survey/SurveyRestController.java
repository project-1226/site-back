package com.example.survey;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/survey")
public class SurveyRestController {
	
	@Autowired
	SurveyDAO dao;
	
	//질문리스트
	@GetMapping("/q_list")
	public List<HashMap<String,Object>> qList(){	
		return dao.qList();
	}
	
	//답변리스트
	@GetMapping("/s_list")
	public List<HashMap<String,Object>> sList(){	
		return dao.sList();
	}

}
