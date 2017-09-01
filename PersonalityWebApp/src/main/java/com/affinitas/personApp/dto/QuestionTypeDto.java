package com.affinitas.personApp.dto;

import java.util.ArrayList;
import java.util.List;

public class QuestionTypeDto {
	private String type;
	private List<String> options= new ArrayList<>();
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
   
}
