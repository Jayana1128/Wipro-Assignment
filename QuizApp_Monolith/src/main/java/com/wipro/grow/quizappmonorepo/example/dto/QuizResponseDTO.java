package com.wipro.grow.quizappmonorepo.example.dto;

public class QuizResponseDTO {
    private Long quizId;
    private String message;

    public QuizResponseDTO() {}

    public QuizResponseDTO(Long quizId, String message) {
        this.quizId = quizId;
        this.message = message;
    }

    public Long getQuizId() { return quizId; }
    public void setQuizId(Long quizId) { this.quizId = quizId; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
