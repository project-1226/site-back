package com.example.exercise;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseRestController {

	@Autowired
	ExerciseDAO dao;
	@GetMapping("/list")
	public List<ExerciseVO> list(@RequestParam("categoryid") String categoryid){
		
		
		return dao.list(categoryid);
	}
}
