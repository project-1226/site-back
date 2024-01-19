package com.example.exercise;

import java.util.HashMap;
import java.util.List;

public interface ExerciseDAO {
	
	
	//카테고리별 운동리스트
	public List<ExerciseVO> list(String categoryid);
	
	
	//나의운동테이블에서 중복체크하기위한 read 
	public ExerciseVO readMyExercise(ExerciseVO vo);
	//운동들을 한번에 insert 
	public int insertMyExercises(List<ExerciseVO> selectedRows);
	//내운동리스트 가져오기(카테고리별)
	public List<ExerciseVO> listMyexercise(String userid,String categoryid);
	
	//마이페이지 -> 운동 카테고리만 출력
	public List<HashMap<String, Object>> listMyExerciseCategory(String userid);
}
