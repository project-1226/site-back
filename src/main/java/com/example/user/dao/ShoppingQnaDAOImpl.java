package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.ShoppingQnaVO;

@Repository
public class ShoppingQnaDAOImpl implements ShoppingQnaDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.ShoppingQnaMapper";

	@Override
	public List<HashMap<String, Object>> listFaq(int categoryid) {
		return session.selectList(namespace + ".list_faq", categoryid);
	}

	@Override
	public void insertQna(ShoppingQnaVO vo) {
		session.insert(namespace + ".insert_qna", vo);
	}

	@Override
	public List<HashMap<String, Object>> listQna(ShoppingQnaVO vo) {
		return session.selectList(namespace + ".list_qna", vo);
	}

	@Override
	public int totalQna(ShoppingQnaVO vo) {
		return session.selectOne(namespace + ".total_qna", vo);
	}

	@Override
	public void deleteQna(ShoppingQnaVO vo) {
		session.delete(namespace + ".delete_qna", vo);
	}

	@Override
	public List<HashMap<String, Object>> listAll(String commentOption) {
		return session.selectList(namespace + ".list_all", commentOption);
	}
}
