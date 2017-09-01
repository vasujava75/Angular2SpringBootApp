package com.affinitas.personApp.dto;

import java.util.ArrayList;
import java.util.List;

public class JsonDataDto {
	private List<String> categories = new ArrayList<>();

	private List<QuestionDto> questions = new ArrayList<>();

	public List<String> getCategories() {
		return categories;
	}

	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

	public List<QuestionDto> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionDto> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "JsonDataDto [categories=" + categories + ", questions=" + questions + "]";
	}
	
	

}
