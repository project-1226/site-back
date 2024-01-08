package com.example.user.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.user.dao.AddressDAO;
import com.example.user.domain.AddressVO;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressDAO dao;

	@Transactional
	@Override
	public void insert(AddressVO vo) {
		if (vo.getSelected() == 1) {
			dao.update_select(vo);
		}
		dao.insert(vo);
	}

	@Override
	public void update(AddressVO vo) {
		if (vo.getSelected() == 1) {
			dao.update_select(vo);
		}
		dao.update(vo);
	}

	@Override
	public HashMap<String, Object> list(AddressVO vo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("list", dao.list(vo));
		map.put("total", dao.total(vo));
		return map;
	}

}
