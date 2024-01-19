package com.example.exercise;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
@Repository
public class AiexerciseDAOImpl implements AiexerciseDAO {
	@Autowired 
	SqlSession session;
	String namespace="com.example.mapper.AiMapper";
	@Override
	public List<HashMap<String, Object>> listAi() {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".list");	
	}
	@Override
	public void insert(AiexerciseVO vo) {
		// TODO Auto-generated method stub
		session.insert(namespace + ".insert", vo);
	}
	@Override
	public List<HashMap<String, Object>> listAiresult(AiexerciseVO vo) {
		// TODO Auto-generated method stub
		return session.selectList(namespace + ".resultlist",vo);	
	}
	
	

}
