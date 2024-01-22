package com.example.purchase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.purchase.dao.OrderDAO;
import com.example.purchase.domain.OrderVO;
import com.example.user.dao.AddressDAO;
import com.example.user.dao.CartDAO;
import com.example.user.domain.AddressVO;
import com.example.user.domain.CartVO;

@Service
public class OrderServiceImpl  implements OrderService {

	@Autowired
	OrderDAO dao;
	@Autowired
	AddressDAO dao2;
	@Autowired
	CartDAO dao3;
	
	
	@Transactional
	@Override
	public void insert(OrderVO vo) {
		System.out.println(vo);
		//addres세팅
		AddressVO newAddress = new AddressVO();
		newAddress.setUserid(vo.getUserid());	
		newAddress.setRecipient(vo.getRecipient()); 
		newAddress.setRecipient_phone(vo.getRecipient_phone());
		newAddress.setAddress1(vo.getAddress1());
		newAddress.setAddress2(vo.getAddress2());
		newAddress.setAddress3(vo.getAddress3());
		
		//-----------------------------------
		dao2.insert(newAddress);
		int newAddressId = dao.getLastAddress(vo.getUserid()); 
		vo.setAddressid(newAddressId);
		dao.insert(vo);
		int newpurchaseID = dao.getPurchaseId(vo.getUserid());
		System.out.println("구매번호------------------------------------------------------"+newpurchaseID);
		vo.setPurchaseid(newpurchaseID);
		System.out.println("VO정보------------------------------------------------------"+vo);
		dao.purchasedetailiinsert(vo);
		String newuserid= vo.getUserid();
		dao.deleteCartByUserId(newuserid);
	
	}


	@Override
	public void insertpd(OrderVO vo) {
		// TODO Auto-generated method stub
	
		dao.insert(vo);
		int newpurchaseID = dao.getPurchaseId(vo.getUserid());
		System.out.println("구매번호------------------------------------------------------"+newpurchaseID);
		vo.setPurchaseid(newpurchaseID);
		System.out.println("VO정보------------------------------------------------------"+vo);
		dao.purchasedetailiinsert(vo);
		String newuserid= vo.getUserid();
		dao.deleteCartByUserId(newuserid);
		
		
		
	}


	
	

}
