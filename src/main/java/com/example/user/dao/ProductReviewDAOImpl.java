package com.example.user.dao;

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
}
