package com.affinitas.personApp.controller;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.affinitas.personApp.PersonalityWebAppApplication;
import com.affinitas.personApp.domain.Answers;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PersonalityWebAppApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PeronalityApiControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetAllQuestions() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.exchange(
				createURLWithPort("PersonalityWebApp/getAllQuestionDetails/hard_fact"), HttpMethod.GET, entity,
				List.class);

		assertNotNull(response.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

	@Test
	public void testGetAllCategories() {
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		@SuppressWarnings("rawtypes")
		ResponseEntity<List> response = restTemplate.exchange(createURLWithPort("PersonalityWebApp/getAllCategories"),
				HttpMethod.GET, entity, List.class);

		assertNotNull(response.getBody());
	}

	@Test
	public void testSaveAnswer() {
		Answers answer = new Answers();
		answer.setAnswer("Junit Test");
		answer.setCategory("Jnit Caegory");
		answer.setQuestion("Junit Question");

		HttpEntity<Answers> entity = new HttpEntity<Answers>(answer, headers);

		ResponseEntity<Boolean> response = restTemplate.exchange(createURLWithPort("PersonalityWebApp/saveAnswer"),
				HttpMethod.POST, entity, Boolean.class);
		assertNotNull(response.getBody());
	}

}
