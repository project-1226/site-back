package com.example.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.AddressVO;

@Repository
public class AddressDAOImpl implements AddressDAO {
	@Autowired
	SqlSession session;
	
	String namespace="com.example.mapper.AddressMapper";

	@Override
	public List<HashMap<String, Object>> list(AddressVO vo) {
		vo.setStart((vo.getPage() - 1) * vo.getSize());
		return session.selectList(namespace + ".list", vo);
	}

	@Override
	public int total(AddressVO vo) {
		return session.selectOne(namespace + ".count_list", vo);
	}
	
	@Override
	public HashMap<String, Object> read(AddressVO vo) {
		return session.selectOne(namespace + ".read", vo);
	}

	@Override
	public void delete(AddressVO vo) {
		session.delete(namespace + ".delete", vo);
	}
	
	@Override
	public void insert(AddressVO vo) {
		session.insert(namespace + ".insert", vo);
	}

	@Override
	public int countList(AddressVO vo) {
		return session.selectOne(namespace + ".count_list");
	}

	@Override
	public int countRead(AddressVO vo) {
		return session.selectOne(namespace + ".count_read");
	}

	@Override
	public void update(AddressVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void update_select(AddressVO vo) {
		session.update(namespace + ".update_select", vo);
	}

}
