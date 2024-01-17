package com.example.survey;

import java.util.HashMap;
import java.util.List;

public interface SurveyDAO {
	public List<HashMap<String,Object>> qList();
	public List<HashMap<String,Object>> sList();
	public int insertResult(List<AnswerVO> insertResult);
}
