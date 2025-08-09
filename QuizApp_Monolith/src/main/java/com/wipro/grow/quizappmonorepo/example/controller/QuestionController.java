package com.wipro.grow.quizappmonorepo.example.controller;

import com.wipro.grow.quizappmonorepo.example.entities.Question;
import com.wipro.grow.quizappmonorepo.example.enums.Category;
import com.wipro.grow.quizappmonorepo.example.service.QuestionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/question")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping
    public Page<Question> getAllQuestions(Pageable pageable){
        return questionService.getAllQuestions(pageable);
    }

    @GetMapping("/category/{category}")
    public List<Question> getQuestionsByCategory(@PathVariable Category category){
        return questionService.getQuestionsByCategory(category);
    }

    @GetMapping("/{id}")
    public Question getQuestionById(@PathVariable Long id){
        return questionService.getQuestionById(id);
    }

    @PostMapping("/add")
    public Question addQuestion(@Valid @RequestBody Question question){
        return questionService.addQuestion(question);
    }

    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Long id, @Valid @RequestBody Question question){
        return questionService.updateQuestion(id, question);
    }

    @DeleteMapping("/{id}")
    public void deleteQuestion(@PathVariable Long id){
        questionService.deleteQuestion(id);
    }
}
