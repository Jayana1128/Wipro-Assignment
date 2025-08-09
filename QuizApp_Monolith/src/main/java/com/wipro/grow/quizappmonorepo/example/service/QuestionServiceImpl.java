package com.wipro.grow.quizappmonorepo.example.service;

import com.wipro.grow.quizappmonorepo.example.entities.Question;
import com.wipro.grow.quizappmonorepo.example.enums.Category;
import com.wipro.grow.quizappmonorepo.example.exception.ResourceNotFoundException;
import com.wipro.grow.quizappmonorepo.example.repos.QuestionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    public QuestionServiceImpl(QuestionRepository questionRepository){ this.questionRepository = questionRepository; }

    @Override
    public Question addQuestion(Question question) { return questionRepository.save(question); }

    @Override
    public Question updateQuestion(Long id, Question question) {
        Question existing = questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id: "+id));
        existing.setTitle(question.getTitle());
        existing.setOptionA(question.getOptionA());
        existing.setOptionB(question.getOptionB());
        existing.setOptionC(question.getOptionC());
        existing.setOptionD(question.getOptionD());
        existing.setCorrectAnswer(question.getCorrectAnswer());
        existing.setCategory(question.getCategory());
        existing.setDifficultyLevel(question.getDifficultyLevel());
        return questionRepository.save(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
        if(!questionRepository.existsById(id)) throw new ResourceNotFoundException("Question not found with id: "+id);
        questionRepository.deleteById(id);
    }

    @Override
    public Question getQuestionById(Long id) {
        return questionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Question not found with id: "+id));
    }

    @Override
    public List<Question> getQuestionsByCategory(Category category) {
        return questionRepository.findByCategory(category);
    }

    @Override
    public Page<Question> getAllQuestions(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }
}
