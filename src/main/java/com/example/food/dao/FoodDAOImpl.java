package com.example.food.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.food.domain.FoodVO;
import com.example.food.domain.MyFoodVO;

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

	@Override
	public List<MyFoodVO> myFoodList(String userid) {
		
		return session.selectList(namespace+".myFoodList", userid);
	}

	@Override
	public List<MyFoodVO> randomMyFood(@Param("categoryid") String categoryid, @Param("foodid") String foodid ) {
		return session.selectList(namespace + ".randomMyFood",Map.of("categoryid", categoryid, "foodid", foodid));
	}

	
//	@Override
//	public List<MyFoodVO> insertmyFoodList(List<MyFoodVO>??) {
//		
//		...... 마지막신단제공 날짜가 현재날짜보다 7일이전 -> 설문조사기반 추천식단음식데이터를 뱉는 함수실행(작성중)  
//		...... input 추천식단리스트 -> 해당데이터 myfoodplan insert 
//		...... 프론트에서 다시 getmyFoodList 
//	
//		return null;
//	}
	
	
	// 마이페이지 푸드플랜
	@Override
	public List<HashMap<String, Object>> myFoodPlanDate(String userid) {
		return session.selectList(namespace + ".planDate", userid);
	}

	@Override
	public List<HashMap<String, Object>> myFoodPlanListOfDate(MyFoodVO vo) {
		return session.selectList(namespace + ".planListOfDate", vo);
	}
}
