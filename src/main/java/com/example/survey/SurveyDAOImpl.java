package com.example.survey;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SurveyDAOImpl implements SurveyDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.SurveyMapper";
	
	@Override
	public List<HashMap<String, Object>> qList() {		
		return session.selectList(namespace+".qList");
	}

	@Override
	public List<HashMap<String, Object>> sList() {
		return session.selectList(namespace+".sList");
	}

	@Override
	public int insertResult(List<AnswerVO> insertResult) {
		return session.insert(namespace+".insertResult", insertResult);
		
	}

}
