package com.affinitas.personApp.service;

import com.affinitas.personApp.dto.JsonDataDto;

public interface JsonDataLoaderService {
	public JsonDataDto loadDataFromFileToH2Db();
}
