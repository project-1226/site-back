package com.example.purchase.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.purchase.dao.OrderDAO;
import com.example.purchase.dao.PurchaseDAO;
import com.example.purchase.domain.OrderVO;
import com.example.purchase.domain.PurchaseVO;
import com.example.purchase.service.PurchaseService;

@RestController
@RequestMapping("/purchase")
public class PurchaseRestController {

	@Autowired
	PurchaseDAO dao;
    @Autowired
    PurchaseService service;

    @PostMapping("/list")
    public HashMap<String, Object> list(@RequestBody PurchaseVO vo) {
        HashMap<String, Object> map = new HashMap<>();

        // PurchaseService의 listPurchase 메서드 호출
        List<HashMap<String, Object>> purchaseList = service.listPurchase(vo);

        // 가져온 데이터를 map에 담아 반환
        map.put("purchaseList", purchaseList);

        return map;
    }
    @PostMapping("/listfromorderid")
    public HashMap<String, Object> listpurchasefromorder(@RequestBody OrderVO vo) {
        HashMap<String, Object> map = new HashMap<>();

        // 가져온 데이터를 map에 담아 반환
        map.put("purchaseList", dao.listpurchasefromorder(vo));

        return map;
    }
    
    
    
}
