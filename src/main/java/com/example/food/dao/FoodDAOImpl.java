package com.example.food.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.food.domain.FoodVO;

@Repository
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.FoodMapper";
	
//	@Override
//	public List<String> categoryList(String type) {
//		List<Object> result = session.selectList(namespace+".categoryList",type);
//		List<String> categories = new ArrayList<>();
//		for (Object row : result) {
//		       Map<String, Object> data = (Map<String, Object>) row;
//		       String categoryName = (String) data.get("name");
//		        // categoryName을 활용하여 필요한 가공을 수행하거나 리스트에 추가할 수 있습니다.
//		       categories.add(categoryName);
//		   }
//		
//		return categories;
//	}
	
	@Override
	public List<Map<String,Object>> categoryList(String type) {
		return session.selectList(namespace+".categoryList",type);
	}
	
	

	@Override
	public List<FoodVO> foodListOfCateg(String categoryid) {
		
		return session.selectList(namespace+".foodListOfCateg",Integer.parseInt(categoryid));
	}

}
