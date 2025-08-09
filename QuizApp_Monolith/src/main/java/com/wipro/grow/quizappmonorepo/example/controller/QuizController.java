package com.wipro.grow.quizappmonorepo.example.controller;

import com.wipro.grow.quizappmonorepo.example.dto.QuizResponseDTO;
import com.wipro.grow.quizappmonorepo.example.entities.QuestionWrapper;
import com.wipro.grow.quizappmonorepo.example.entities.Response;
import com.wipro.grow.quizappmonorepo.example.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/quiz")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/create")
    public QuizResponseDTO createQuiz(@RequestParam String category, @RequestParam String difficulty){
        return quizService.createQuiz(category, difficulty);
    }

    @GetMapping("/{id}/questions")
    public List<QuestionWrapper> getQuizQuestions(@PathVariable Long id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("/{id}/submit")
    public Integer submitQuiz(@PathVariable Long id, @RequestBody List<Response> responses){
        return quizService.calculateScore(id, responses);
    }
}
