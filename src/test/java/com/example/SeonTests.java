package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.dao.AddressDAO;
import com.example.user.dao.UserDAO;
import com.example.user.domain.AddressVO;
import com.example.user.domain.UserVO;

@SpringBootTest
class SeonTests {
	@Autowired
	UserDAO udao;

	@Autowired
	AddressDAO adao;

	@MockBean
	UserVO uvo;

	@MockBean
	AddressVO avo;

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("회원가입시 닉네임, 아바타 자동 설정 테스트")
	@Test
	@Transactional
	void insertUserTest() {
		// given
		UserVO vo = new UserVO();
		vo.setEmail("test@test.com");
		vo.setPassword("test");

		// when
		udao.insert(vo);

		// then
		assertEquals("test", vo.getNickname());
		assertEquals("http://via.placeholder.com/100x100?text=T", vo.getAvatar());
	}

	@Disabled("이 테스트는 필요하지 않습니다.")
	@DisplayName("배송지 삭제")
	@Test
	@Transactional
	void deleteAddressTest() {
		// given
		AddressVO vo = new AddressVO();
		vo.setUserid("e91b8eb6-24af-404a-b");
		vo.setAddressid(14);

		// when
		adao.delete(vo);
		int result;
		result = adao.countRead(vo);

		// then
		assertEquals(0, result);
	}

}
