package com.example.exercise;

import java.util.List;

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

	
}
