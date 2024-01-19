package com.example.exercise;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.exercise.AiexerciseVO;
import com.example.purchase.domain.PurchaseVO;

@RestController
@RequestMapping("/ai")
public class AiexerciseRestController {
	@Autowired
	AiexerciseDAO dao;
	
	
	 @PostMapping("/list")
	    public HashMap<String, Object> list() {
	        HashMap<String, Object> map = new HashMap<>();

	        // PurchaseService의 listPurchase 메서드 호출
	        List<HashMap<String, Object>> Ailist = dao.listAi();

	        // 가져온 데이터를 map에 담아 반환
	        map.put("Ailist", Ailist);

	        return map;
	    }
		@PostMapping("/insertuserinfo")
		public void insert(@RequestBody AiexerciseVO vo) {					
			dao.insert(vo);
		}
		
		 @PostMapping("/listAiresult")
		    public HashMap<String, Object> listAiresult(@RequestBody AiexerciseVO vo) {
		        HashMap<String, Object> map = new HashMap<>();
		        System.out.println(vo);
		        // PurchaseService의 listPurchase 메서드 호출
		        List<HashMap<String, Object>> Airesultlist = dao.listAiresult(vo);

		        // 가져온 데이터를 map에 담아 반환
		        map.put("Airesultlist", Airesultlist);

		        return map;
		    }
}
