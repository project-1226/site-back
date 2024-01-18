package com.example.exercise;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exercise")
public class ExerciseRestController {

	@Autowired
	ExerciseDAO dao;
	
	@Autowired
	ExerciseService serviece;
	
	//카테고리별 운동리스트
	@GetMapping("/list")
	public List<ExerciseVO> list(@RequestParam("categoryid") String categoryid){		
		return dao.list(categoryid);
	}
	
	//선택한 운동 나의운동테이블에 저장
	@PostMapping("/insert/my_exercise")
	public int insertMyExercises(@RequestBody List<ExerciseVO> selectedRows) {	
		//내운동에서 중복제거이후 저장
		return serviece.insertMyExercises(selectedRows);
	}
	//카테고리별 내운동들 가져오기
	@GetMapping("/myexercises")
	public List<ExerciseVO> listMyexercise(@RequestParam("userid") String userid,@RequestParam("categoryid") String categoryid){		
		return dao.listMyexercise(userid, categoryid);
	}
	
	//사용자가 선택한 운동의 카테고리만 출력
	@GetMapping("/categoryList")
	public List<HashMap<String, Object>> listMyExerciseCategory(@RequestParam("userid") String userid) {
		return dao.listMyExerciseCategory(userid);
	}
}
