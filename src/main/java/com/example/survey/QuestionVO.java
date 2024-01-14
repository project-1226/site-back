package com.example.survey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class QuestionVO {
	private int questionid;
	private String content;
	private int type;
}
