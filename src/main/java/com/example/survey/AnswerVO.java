package com.example.survey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AnswerVO {
    private int selectid;
    private String userid;
    private int questionid;
    private String input_text;
}
