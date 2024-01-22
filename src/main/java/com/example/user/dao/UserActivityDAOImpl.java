package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.UserActivityVO;

@Repository
public class UserActivityDAOImpl implements UserActivityDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.UserActivityMapper";

	@Override
	public List<HashMap<String, Object>> listPost(UserActivityVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list_post", vo);
	}

	@Override
	public List<HashMap<String, Object>> listComment(UserActivityVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list_comment", vo);
	}

	@Override
	public int totalPost(UserActivityVO vo) {
		return session.selectOne(namespace + ".total_post", vo);
	}

	@Override
	public int totalComment(UserActivityVO vo) {
		return session.selectOne(namespace + ".total_comment", vo);
	}

	@Override
	public int countComment(UserActivityVO vo) {
		return session.selectOne(namespace + ".count_comment", vo);
	}
	
}
