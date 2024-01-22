package com.example.exercise;

import java.util.HashMap;
import java.util.List;

import com.example.purchase.domain.OrderVO;



public interface AiexerciseDAO {
	public List<HashMap<String,Object>> listAi();
	public void insert(AiexerciseVO vo);
	public List<HashMap<String,Object>> listAiresult(AiexerciseVO vo);
	
}
