package com.example.food.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community_admin.domain.ProductVO;

@Repository
public class ProductDAOImpl implements ProductDAO  {
	
	@Autowired 
	SqlSession session;
	String namespace="com.example.mapper.ProductMapper";
	
	@Override
	public ProductVO searchIngredient(String ingredient) {
		
		return session.selectOne(namespace+".searchIngredient",ingredient); //
	}

}
