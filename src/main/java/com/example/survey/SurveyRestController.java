package com.example.survey;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	//설문조사 결과저장
//	@PostMapping("/insert_result")
//	public int insertResult(@RequestBody List<AnswerVO>  surveyResultList) {
//		return dao.insertResult(surveyResultList);
//	}

}
