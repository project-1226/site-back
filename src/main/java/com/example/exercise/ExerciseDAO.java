package com.example.exercise;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

public interface ExerciseDAO {
	
	
	//카테고리별 운동리스트
	public List<ExerciseVO> list(String categoryid);
	
	
	//나의운동테이블에서 중복체크하기위한 read 
	public ExerciseVO readMyExercise(ExerciseVO vo);
	//운동들을 한번에 insert 
	public int insertMyExercises(List<ExerciseVO> selectedRows);
	//내운동리스트 가져오기(카테고리별)
	public List<ExerciseVO> listMyexercise(String userid,String categoryid);
	
}
