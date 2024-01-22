package com.example.user.dao;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.user.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	SqlSession session;

	String namespace = "com.example.mapper.UserMapper";

	@Override
	public String insert(UserVO vo) {
		// userid 자동 생성
	    boolean isDuplicate = true;
	    String userid;
	    while (isDuplicate) {
	        userid = UUID.randomUUID().toString().substring(0, 20);
	        vo.setUserid(userid);
	        int count = isUser(vo);
	        if (count == 0) {
	            isDuplicate = false;
	        }
	    }
		
		// 닉네임 자동 생성
	    String emailString = vo.getEmail();
	    String[] parts = emailString.split("@");
	    String nickname = parts[0];
	    vo.setNickname(nickname);

	    // 아바타 자동 생성
	    if (vo.getAvatar() == null) {
	        String str = nickname.substring(0, 1).toUpperCase();
	        String photo = "http://via.placeholder.com/100x100?text=" + str;
	        vo.setAvatar(photo);
	    }
	    
	    // 휴대폰 번호 일괄 입력
	    vo.setPhone("");
	    
	    // 포인트 적립
	    vo.setPoint(3000);
	    
	    vo.toString();

	    session.insert(namespace + ".insert", vo);
	    return vo.getUserid();
	    
	}

	@Override
	public HashMap<String, Object> read(UserVO vo) {
		return session.selectOne(namespace + ".read", vo);
	}

	@Override
	public void update(UserVO vo) {
		session.update(namespace + ".update", vo);
	}

	@Override
	public int isUser(UserVO vo) {
		return session.selectOne(namespace + ".count_read", vo);
	}

	@Override
	public List<HashMap<String, Object>> readUserSurvey(String userid) {
		return session.selectList(namespace + ".read_user_survey", userid);
	}

	@Override
	public void updateUserSurvey(UserVO vo) {
		session.update(namespace + ".update_user_survey", vo);
	}

	@Override
	public void insertUserSurvey(UserVO vo) {
		session.insert(namespace + ".insert_user_survey", vo);
	}

	@Override
	public List<HashMap<String, Object>> getUserSurvey(UserVO vo) {
		return session.selectList(namespace + ".get_user_survey", vo);
	}

	@Override
	public int isDuplicate(UserVO vo) {
		return session.selectOne(namespace + ".is_duplicate", vo);
	}

	@Override
	public List<HashMap<String, Object>> listAllergy() {
		return session.selectList(namespace + ".list_allergy");
	}

}
