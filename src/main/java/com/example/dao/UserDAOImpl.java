package com.example.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SqlSession session;

	String namespace = "com.example.mapper.UserMapper";

	@Override
	public void insert(UserVO vo) {
	    String emailString = vo.getEmail();
	    String[] parts = emailString.split("@");
	    String nickname = parts[0];
	    vo.setNickname(nickname);

	    // 아바타 설정
	    if (vo.getAvatar() == null) {
	        String str = nickname.substring(0, 1).toUpperCase();
	        String photo = "http://via.placeholder.com/100x100?text=" + str;
	        vo.setAvatar(photo);
	    }
	    
	    vo.setPoint(3000);

	    session.insert(namespace + ".insert", vo);
	}

	@Override
	public HashMap<String, Object> read(String email) {
		return session.selectOne(namespace + ".read", email);
	}

}
