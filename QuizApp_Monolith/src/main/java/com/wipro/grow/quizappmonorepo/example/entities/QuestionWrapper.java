package com.wipro.grow.quizappmonorepo.example.entities;

public class QuestionWrapper {
    private Long id;
    private String title;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;

    public QuestionWrapper(){}
    public QuestionWrapper(Long id,String title,String optionA,String optionB,String optionC,String optionD){
        this.id=id;this.title=title;this.optionA=optionA;this.optionB=optionB;this.optionC=optionC;this.optionD=optionD;
    }
    public Long getId(){return id;}
    public String getTitle(){return title;}
    public String getOptionA(){return optionA;}
    public String getOptionB(){return optionB;}
    public String getOptionC(){return optionC;}
    public String getOptionD(){return optionD;}
}
