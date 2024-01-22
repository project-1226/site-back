package com.example.community_admin.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community_admin.domain.CommentVO;
import com.example.community_admin.domain.PostVO;
import com.example.community_admin.domain.ProductVO;
import com.example.community_admin.domain.QueryVO;

@Repository
public class AdminDAOImpl implements AdminDAO{

	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.AdminMapper";
	
	@Override
	public void insert(PostVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public List<HashMap<String, Object>> list(int categoryid) {
		return session.selectList(namespace + ".list", categoryid);
	}

	@Override
	public void update(PostVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void deletePost(int postid) {
		session.delete(namespace + ".deletePost", postid);	
	}
	
	
	@Override
	public List<HashMap<String, Object>> userList() {
		return session.selectList(namespace + ".userList");
	}

	@Override
	public void insertProduct(ProductVO vo) {
		session.insert(namespace + ".insertProduct", vo);
	}

	@Override
	public void insertProR(HashMap<String, Object> map) {
		session.insert(namespace + ".insertProR", map);
	}

	@Override
	public void updateProduct(ProductVO vo) {
		session.update(namespace + ".updateProduct", vo);
	}

	@Override
	public void deleteProduct(int productid) {
		session.delete(namespace + ".deleteProduct", productid);
	}

	@Override
	public void deleteImage(int productid) {
		session.delete(namespace + ".deleteImage", productid);
	}

	@Override
	public List<HashMap<String, Object>> productList(QueryVO vo) {
		vo.setStart((vo.getPage()-1) * vo.getSize());
		return session.selectList(namespace + ".productList", vo);
	}

	@Override
	public int total(QueryVO vo) {
		return session.selectOne(namespace + ".total", vo);
	}

	@Override
	public List<HashMap<String, Object>> imageList(int productid) {
		return session.selectList(namespace + ".imageList", productid);
	}

	@Override
	public void insertImage(ProductVO vo) {
		vo.getProductid();
		session.insert(namespace + ".insertImage", vo);
	}

	@Override
	public List<HashMap<String, Object>> qnaList(String userid) {
		return session.selectList(namespace + ".qnaList", userid);
	}

	@Override
	public void insertQnaComment(CommentVO vo) {
		session.insert(namespace + ".insertQnaComment", vo);
	}

	@Override
	public List<HashMap<String, Object>> orderList() {
		return session.selectList(namespace + ".orderList");
	}
	
}
