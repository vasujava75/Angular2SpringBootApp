package com.affinitas.personApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;

import com.affinitas.personApp.serviceImpl.JsonDataLoaderServiceImpl;

@SpringBootApplication
public class PersonalityWebAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context = SpringApplication.run(PersonalityWebAppApplication.class, args);
		 context.getBean(JsonDataLoaderServiceImpl.class).loadDataFromFileToH2Db();;
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PersonalityWebAppApplication.class);
	}

}
