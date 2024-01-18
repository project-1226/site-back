package com.example.exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ExerciseDAOImpl implements ExerciseDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.ExerciseMapper";
	
	@Override
	public List<ExerciseVO> list(String categoryid) {		
		return session.selectList(namespace + ".list", categoryid);
	}
	
	
	
	@Override
	public ExerciseVO readMyExercise(ExerciseVO vo) {		
		return session.selectOne(namespace+".readMyExercise",vo);
	}

	@Override
	public int insertMyExercises(List<ExerciseVO> selectedRows) {	
		//실제 중복체크이후 실제 insert해야하는 것들만 insert
		return session.insert(namespace+".insertMyExercises", selectedRows);
	}



	@Override
	public List<ExerciseVO> listMyexercise(@Param("userid") String userid, @Param("categoryid") String categoryid) {	
//		Map<String, Object> params = new HashMap<>();
//		params.put("userid", userid);
//		params.put("categoryid", categoryid);
//		return session.selectList(namespace + ".listMyexercise", params);				
		return session.selectList(namespace+".listMyexercise",Map.of("userid", userid, "categoryid", categoryid));
	}



	@Override
	public List<HashMap<String, Object>> listMyExerciseCategory(String userid) {
		return session.selectList(namespace + ".myPlanCategory", userid);
	}

	
}
