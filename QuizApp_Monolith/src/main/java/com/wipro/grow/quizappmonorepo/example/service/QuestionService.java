package com.wipro.grow.quizappmonorepo.example.service;

import com.wipro.grow.quizappmonorepo.example.entities.Question;
import com.wipro.grow.quizappmonorepo.example.enums.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface QuestionService {
    Question addQuestion(Question question);
    Question updateQuestion(Long id, Question question);
    void deleteQuestion(Long id);
    Question getQuestionById(Long id);
    List<Question> getQuestionsByCategory(Category category);
    Page<Question> getAllQuestions(Pageable pageable);
}
