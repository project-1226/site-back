package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.UserFavoriteVO;

@Repository
public class UserFavoriteDAOImpl implements UserFavoriteDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.UserFavoriteMapper";

	@Override
	public List<HashMap<String, Object>> listProduct(UserFavoriteVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list_fproduct", vo);
	}

	@Override
	public int totalProduct(String userid) {
		return session.selectOne(namespace + ".total_fproduct", userid);
	}

	@Override
	public List<HashMap<String, Object>> listImage(UserFavoriteVO vo) {
		return session.selectList(namespace + ".list_image", vo);
	}

	@Override
	public void delete(int favoriteid) {
		session.delete(namespace + ".delete", favoriteid);
	}
}
