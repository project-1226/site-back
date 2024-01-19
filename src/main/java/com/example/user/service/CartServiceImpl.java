package com.example.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.community_admin.domain.ProductVO;
import com.example.food.dao.ProductDAO;
import com.example.user.dao.CartDAO;
import com.example.user.domain.CartVO;

@Service
public class CartServiceImpl  implements CartService{

	@Autowired
	CartDAO cdao;
	
	@Autowired
	ProductDAO pdao;
	

	@Transactional
	@Override
	public void insert(CartVO vo) {
		int check=cdao.check(vo);
		if(check==0) {
			cdao.insert(vo);
		}else {
			vo.setCount(1);
			cdao.update(vo);
		}
	}

	@Transactional
	@Override
	//병렬처리하려고 해봤는데 좀 그러면 insert for문으로 실행해서 값받아오는내용으로 수정하기
	public int insertList(List<String> ingreList) { 
		int cnt = 0;
		//마지막 요소 userid
	    String userid = ingreList.get(ingreList.size() - 1);
	    
	    // 나머지 요소 ingredients
	    List<String> ingredients = new ArrayList<>(ingreList.subList(0, ingreList.size() - 1));	    
	    
	    //ingredients의 요소들을 -> pdao.searchIngredient(요소) 쿼리실행 병렬처리
	    // CompletableFuture를 사용
	    List<CompletableFuture<ProductVO>> futures = ingredients.stream()
	            .map(ingredient -> CompletableFuture.supplyAsync(() -> pdao.searchIngredient(ingredient))
		            .exceptionally(ex -> { //pdao함수실행결과 null인경우 예외처리	                   	                    
	                    return new ProductVO(); //빈 맵을 반환합니다.
	                }))
	            .collect(Collectors.toList());
	    
	    // 모든 CompletableFuture가 완료될 때까지 대기
	    CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
	    allOf.join();
	    
	    // CompletableFuture의 결과를 수집 = results 각각의 pdao.searchIngredient(ingredient)의 결과값들
	    List<ProductVO> products = futures.stream()
	            .map(CompletableFuture::join) // join을 사용하여 CompletableFuture의 결과에 접근
	            .collect(Collectors.toList());
	   
	    
	    //supplyAsync수행결과 null인경우 CompletableFuture에서 예외가 발생하면 해당 예외는 Future의 결과로 간주되어 CompletableFuture가 완료
	    //results 리스트에는 예외 객체가 들어감
	    
	    List<CartVO> cart = new ArrayList<>(); 
	    for (ProductVO product : products) {
	        if (product != null) { //에러처리했는데 왜 null이지?ㅠㅠㅠ
	        
	        	
	            CartVO c = new CartVO();
	            c.setCount(1);	          	            
	            c.setProductid(product.getProductid());
	            c.setUserid(userid);
	            insert(c);
	            cnt += 1;
	            //cart.add(c);
	        } else {
	        	System.out.println("pdao.searchIngredient(ingredient) = null");
	            continue;	            
	        }
	    }
	    
	    //return cdao.insertList(cart); 
	    	return cnt;
	}

}

	

