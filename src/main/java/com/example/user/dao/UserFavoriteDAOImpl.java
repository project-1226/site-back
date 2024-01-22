package com.example.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.UserFavoriteFoodVO;
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

	@Override
	public List<UserFavoriteFoodVO> listFood(@Param("userid") String userId,
			@Param("page")int page,@Param("size")int size) { 	
		//@Param()으로 지정안해줘도 자동으로 매핑되기는하는데 여러개를 mapper로 보내줄거라 혹시몰라서 붙임	
		return session.selectList(namespace+".list_ffood",Map.of("userid", userId, "start",(page-1)*size,"size",size));
	}
	@Override
	public int totalFood(String userid) {	
		return session.selectOne(namespace+".total_ffood",userid);
	}
}
