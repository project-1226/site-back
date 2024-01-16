package com.example.survey;

import java.util.List;

import com.example.user.domain.UserVO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SurvetInsertDTO {
	private UserVO user;
	private List<AnswerVO> result;
	
	@Override
	public String toString() {
		String strUser = user.toString();
		String strResult= "";
		for (AnswerVO answer : result) {
			strResult += answer.toString();
			strResult += ",";
        }
		
		return "SurvetInsertDTO [user=" + strUser + ", result=" + strResult + "]";
	}
	
	
	
}
