package com.affinitas.personApp.serviceImpl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.affinitas.personApp.dto.JsonDataDto;
import com.affinitas.personApp.service.JsonDataLoaderService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class JsonDataLoaderServiceImplTest {

	@Autowired
	JsonDataLoaderService jsonDataLoaderServic;
	@Test
	public void testLoadDataFromFileToH2Db() {
		JsonDataDto dto= jsonDataLoaderServic.loadDataFromFileToH2Db();
		System.out.println(dto);
		 assertNotNull(dto);
	}

}
