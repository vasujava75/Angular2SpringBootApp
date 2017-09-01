package com.affinitas.personApp.serviceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import com.affinitas.personApp.domain.Category;
import com.affinitas.personApp.domain.Questions;
import com.affinitas.personApp.dto.JsonDataDto;
import com.affinitas.personApp.dto.QuestionDto;
import com.affinitas.personApp.repository.CategoryRepository;
import com.affinitas.personApp.repository.QuestionsRepository;
import com.affinitas.personApp.service.JsonDataLoaderService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class JsonDataLoaderServiceImpl implements JsonDataLoaderService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	ResourceLoader resourceLoader;
	@Autowired
	QuestionsRepository questionsRepository;
	@Autowired
	CategoryRepository categoryRepository;

	@Transactional
	public JsonDataDto loadDataFromFileToH2Db() {
		ObjectMapper mapper = new ObjectMapper();
		JsonDataDto jsonDataObject = null;
		try {
			jsonDataObject = mapper.readValue(resourceLoader.getResource("classpath:dataFile.json").getFile(),
					JsonDataDto.class);
			if (jsonDataObject != null) {
				List<QuestionDto> questionsDtos = jsonDataObject.getQuestions();
				List<Questions> questionsList = new ArrayList<>();
				List<Category> categorieList = new ArrayList<>();
				questionsDtos.forEach(questionDto -> {
					Questions question = new Questions();
					question.setQuestion(questionDto.getQuestion());
					question.setCategory(questionDto.getCategory());
					question.setQuestionType(questionDto.getQuestion_type().getType());
					question.setOptions(questionDto.getQuestion_type().getOptions().toString());
					questionsList.add(question);
				});
				questionsRepository.save(questionsList);
				jsonDataObject.getCategories().forEach( categoryItem-> {
					Category category = new Category();
					category.setCategory(categoryItem);
					categorieList.add(category);
				});
				categoryRepository.save(categorieList);
			}
		} catch (IOException e) {
			logger.error("File read exception");
		}
		return jsonDataObject;
	}
}
