package com.example.food.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.food.domain.FoodVO;
import com.example.food.domain.MyFoodVO;

@Repository
public class FoodDAOImpl implements FoodDAO{

	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.FoodMapper";
	
	@Override
	public List<Map<String,Object>> categoryList(String type) {
		return session.selectList(namespace+".categoryList",type);
	}

	@Override
	public List<FoodVO> foodListOfCateg(String categoryid) {		
		return session.selectList(namespace+".foodListOfCateg",categoryid);
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
	@Override
	public int updateMyFood(@Param("foodplanid") String foodplanid, @Param("foodid") String foodid) {		
		return session.update(namespace+".updateMyFood",Map.of("foodplanid", foodplanid, "foodid", foodid));
	}
	@Override
	public int readFavorite(@Param("userid")String userid,@Param("foodid") String foodid) {	
		return session.selectOne(namespace+".readFavorite",Map.of("userid", userid, "foodid", foodid));
	}
	@Override
	public int insetFavorite(@Param("userid")String userid,@Param("foodid") String foodid) {
		return session.insert(namespace+".insertFavorite",Map.of("userid", userid, "foodid", foodid));
	}
	@Override
	public int deleteFavorite(@Param("userid")String userid,@Param("foodid") String foodid) {
		return session.delete(namespace+".deleteFavorite",Map.of("userid", userid, "foodid",Integer.parseInt(foodid)));
	}

	
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
