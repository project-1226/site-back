package com.example.purchase.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.purchase.dao.PurchaseDAO;
import com.example.purchase.domain.PurchaseVO;
@Service
public class PurchaseServiceImpl implements PurchaseService {
    @Autowired
    PurchaseDAO dao;

    @Override
    public List<HashMap<String, Object>> listPurchase(PurchaseVO vo) {
        String newUserid = vo.getUserid();

        // 1. userid에 해당하는 최근 purchaseid를 가져옵니다.
        int newpurchaseid = dao.getPurchaseIdfordetail(newUserid);

        // 2. PurchaseVO 객체를 생성하여 값을 설정합니다.
        PurchaseVO purchaseVO = new PurchaseVO();
        purchaseVO.setPurchaseid(newpurchaseid);

        // 3. 가져온 purchaseid를 사용하여 listPurchase 메서드를 호출하여 구매 목록을 가져옵니다.
        List<HashMap<String, Object>> purchaseList = dao.listPurchase(purchaseVO);

        // 이후 필요한 로직을 추가하세요.

        return purchaseList;
    }
}
