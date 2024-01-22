package com.example.survey;

import java.util.ArrayList;
import java.util.List;

import com.example.food.domain.FoodVO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnswerVO {
	private List<AnswerVO> answers = new ArrayList<>();
	
    private int selectid;
    private String userid;
    private int questionid;
    private String input_text;
}
