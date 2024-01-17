package com.example.exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExerciseService {
	
	@Autowired
	 ExerciseDAO dao;
	
	
	//insert하기전 테이블조회이후 없는 ExerciseVO들만 리턴
	@Transactional
	public int insertMyExercises(List<ExerciseVO> selectedRows) {
		
		List<ExerciseVO> result = new ArrayList<ExerciseVO>();
		for(ExerciseVO exercise :selectedRows) {
			Optional<ExerciseVO> queryResult = Optional.ofNullable(dao.readMyExercise(exercise));
			if (!queryResult.isPresent()) {
				result.add(exercise);
		    }			
		}
		//저장할게 없을때 
		if(result.size() == 0) {
			return 0;
		}
		//저장한게 있을때 -> insert된 행 숫자 리턴
		return dao.insertMyExercises(result);
	}
	
}