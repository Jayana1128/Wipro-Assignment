package com.wipro.grow.quizappmonorepo.example.service;

import com.wipro.grow.quizappmonorepo.example.dto.QuizResponseDTO;
import com.wipro.grow.quizappmonorepo.example.entities.Question;
import com.wipro.grow.quizappmonorepo.example.entities.QuestionWrapper;
import com.wipro.grow.quizappmonorepo.example.entities.Quiz;
import com.wipro.grow.quizappmonorepo.example.entities.Response;
import com.wipro.grow.quizappmonorepo.example.enums.Category;
import com.wipro.grow.quizappmonorepo.example.enums.DifficultyLevel;
import com.wipro.grow.quizappmonorepo.example.exception.ResourceNotFoundException;
import com.wipro.grow.quizappmonorepo.example.repos.QuestionRepository;
import com.wipro.grow.quizappmonorepo.example.repos.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizServiceImpl implements QuizService {

    private final QuizRepository quizRepository;
    private final QuestionRepository questionRepository;

    public QuizServiceImpl(QuizRepository quizRepository, QuestionRepository questionRepository){
        this.quizRepository = quizRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public QuizResponseDTO createQuiz(String categoryStr, String difficultyStr) {
        Category category = Category.valueOf(categoryStr.toUpperCase());
        DifficultyLevel difficulty = DifficultyLevel.valueOf(difficultyStr.toUpperCase());

        List<Question> questions = questionRepository.findRandomQuestionsByCategoryAndLevel(category.name(), difficulty.name());

        if(questions == null || questions.isEmpty()) {
            questions = questionRepository.findByCategoryAndDifficultyLevel(category, difficulty);
        }

        if(questions == null || questions.isEmpty()) {
            throw new ResourceNotFoundException("No questions found for category="+category+" and difficulty="+difficulty);
        }

        Quiz quiz = new Quiz();
        quiz.setTitle(category.name()+" Quiz - "+difficulty.name());
        quiz.setQuestions(questions.stream().limit(3).collect(Collectors.toList()));
        Quiz saved = quizRepository.save(quiz);

        return new QuizResponseDTO(saved.getId(), "Quiz created successfully");
    }

    @Override
    public List<QuestionWrapper> getQuizQuestions(Long quizId) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: "+quizId));
        List<QuestionWrapper> list = new ArrayList<>();
        for(Question q: quiz.getQuestions()){
            list.add(new QuestionWrapper(q.getId(), q.getTitle(), q.getOptionA(), q.getOptionB(), q.getOptionC(), q.getOptionD()));
        }
        return list;
    }

    @Override
    public Integer calculateScore(Long quizId, List<Response> responses) {
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new ResourceNotFoundException("Quiz not found with id: "+quizId));
        int score = 0;
        for(Response r: responses){
            for(Question q: quiz.getQuestions()){
                if(q.getId().equals(r.getQuestionId()) && q.getCorrectAnswer().equalsIgnoreCase(r.getSelectedOption())){
                    score++;
                }
            }
        }
        return score;
    }
}
