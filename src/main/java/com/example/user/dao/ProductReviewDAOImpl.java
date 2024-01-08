package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.ProductReviewVO;

@Repository
public class ProductReviewDAOImpl implements ProductReviewDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.ProductReviewMapper";
	
	@Override
	public void insert(ProductReviewVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<HashMap<String, Object>> list(ProductReviewVO vo) {
		return session.selectOne(namespace + ".list_user", vo);
	}

	@Override
	public List<HashMap<String, Object>> image(ProductReviewVO vo) {
		return session.selectList(namespace + ".list_image");
	}
}
