package com.affinitas.personApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.affinitas.personApp.domain.Answers;
import com.affinitas.personApp.domain.Category;
import com.affinitas.personApp.domain.Questions;
import com.affinitas.personApp.repository.AnswersRepository;
import com.affinitas.personApp.repository.CategoryRepository;
import com.affinitas.personApp.repository.QuestionsRepository;

@RestController
/*
 * Below cross origin is required when we are working client and server or different ports.
 * 
 */
public class PeronalityApiController {

	@Autowired
	QuestionsRepository questionsRepository;

	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	AnswersRepository answersRepository;

	
	@RequestMapping("getAllQuestionDetails/{category}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Questions> getAllQuestions(@PathVariable("category") String category) {
		return questionsRepository.findAllByCategory(category);
	}

	@RequestMapping("getAllCategories")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}
	
	@RequestMapping( value = "/saveAnswer", method = RequestMethod.POST)
	@CrossOrigin(origins = "http://localhost:4200")
	public boolean saveAnswer(@RequestBody Answers answer) {
		 answersRepository.save(answer);
		 return true;
	}
}
