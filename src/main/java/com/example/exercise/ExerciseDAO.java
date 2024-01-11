package com.example.exercise;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface ExerciseDAO {
	
	
	//운동메인에서 카테고리 선택시 모달에서 받는 데이터
	public List<ExerciseVO> list(String categoryid);
}
