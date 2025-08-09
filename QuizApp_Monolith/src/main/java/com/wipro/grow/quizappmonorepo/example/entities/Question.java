package com.wipro.grow.quizappmonorepo.example.entities;

import com.wipro.grow.quizappmonorepo.example.enums.Category;
import com.wipro.grow.quizappmonorepo.example.enums.DifficultyLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "question_table")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "question_title")
    private String title;

    @NotBlank
    @Column(name = "optiona")
    private String optionA;

    @NotBlank
    @Column(name = "optionb")
    private String optionB;

    @NotBlank
    @Column(name = "optionc")
    private String optionC;

    @NotBlank
    @Column(name = "optiond")
    private String optionD;

    @NotBlank
    @Column(name = "correct_answer")
    private String correctAnswer;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Category category;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "difficulty_level")
    private DifficultyLevel difficultyLevel;

    // getters and setters omitted for brevity
    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public String getTitle(){return title;}
    public void setTitle(String title){this.title=title;}
    public String getOptionA(){return optionA;}
    public void setOptionA(String optionA){this.optionA=optionA;}
    public String getOptionB(){return optionB;}
    public void setOptionB(String optionB){this.optionB=optionB;}
    public String getOptionC(){return optionC;}
    public void setOptionC(String optionC){this.optionC=optionC;}
    public String getOptionD(){return optionD;}
    public void setOptionD(String optionD){this.optionD=optionD;}
    public String getCorrectAnswer(){return correctAnswer;}
    public void setCorrectAnswer(String correctAnswer){this.correctAnswer=correctAnswer;}
    public Category getCategory(){return category;}
    public void setCategory(Category category){this.category=category;}
    public DifficultyLevel getDifficultyLevel(){return difficultyLevel;}
    public void setDifficultyLevel(DifficultyLevel difficultyLevel){this.difficultyLevel=difficultyLevel;}
}
