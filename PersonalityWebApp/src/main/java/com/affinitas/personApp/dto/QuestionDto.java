package com.affinitas.personApp.dto;


public class QuestionDto {
	
	private String question;
	private String category;
	private QuestionTypeDto question_type;
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public QuestionTypeDto getQuestion_type() {
		return question_type;
	}
	public void setQuestion_type(QuestionTypeDto question_type) {
		this.question_type = question_type;
	}
    
}
