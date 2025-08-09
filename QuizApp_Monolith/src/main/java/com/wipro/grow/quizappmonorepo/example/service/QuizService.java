package com.wipro.grow.quizappmonorepo.example.service;

import com.wipro.grow.quizappmonorepo.example.dto.QuizResponseDTO;
import com.wipro.grow.quizappmonorepo.example.entities.QuestionWrapper;
import com.wipro.grow.quizappmonorepo.example.entities.Response;

import java.util.List;

public interface QuizService {
    QuizResponseDTO createQuiz(String category, String difficultyLevel);
    List<QuestionWrapper> getQuizQuestions(Long quizId);
    Integer calculateScore(Long quizId, List<Response> responses);
}
