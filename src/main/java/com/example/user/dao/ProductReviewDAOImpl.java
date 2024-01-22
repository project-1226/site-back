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
	public List<HashMap<String, Object>> listReviewO(ProductReviewVO vo) {	
		return session.selectList(namespace + ".list_user", vo);
	}
	
	@Override
	public int total(String userid) {
		return session.selectOne(namespace + ".total", userid);
	}

	@Override
	public List<HashMap<String, Object>> image(int product_reviewid) {
		return session.selectList(namespace + ".list_image", product_reviewid);
	}

	@Override
	public void deleteReview(int product_reviewid) {
		session.delete(namespace + ".delete_review", product_reviewid);
	}

	@Override
	public void deleteImage(int product_reviewid) {
		session.delete(namespace + ".delete_image", product_reviewid);
	}

	@Override
	public int isImage(int product_reviewid) {
		return session.selectOne(namespace + ".count_image", product_reviewid);
	}

	@Override
	public HashMap<String, Object> read(int product_reviewid) {
		return session.selectOne(namespace + ".read", product_reviewid);
	}

	@Override
	public List<HashMap<String, Object>> listReviewX(ProductReviewVO vo) {
		return session.selectList(namespace + ".require_review", vo);
	}

	@Override
	public int totalReviewX(String userid) {
		return session.selectOne(namespace + ".total_require_review", userid);
	}

}
