package com.wipro.grow.quizappmonorepo.example.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.grow.quizappmonorepo.example.entities.Question;
import com.wipro.grow.quizappmonorepo.example.enums.Category;
import com.wipro.grow.quizappmonorepo.example.enums.DifficultyLevel;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    @Query(value = "SELECT * FROM question_table q WHERE q.category = :category AND q.difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)
    List<Question> findRandomQuestionsByCategoryAndLevel(String category, String difficulty);

    List<Question> findByCategory(Category category);

    List<Question> findByCategoryAndDifficultyLevel(Category category, DifficultyLevel difficultyLevel);
}
