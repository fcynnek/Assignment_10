package com.fcynnek.Assignment_10.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_10.api.SpoonacularIntegration;
import com.fcynnek.Assignment_10.dto.WeekResponse;
import com.google.gson.Gson;

@Service
public class ApiService {

	SpoonacularIntegration spoonacularAPI = new SpoonacularIntegration();
	
	public ApiService() {
		// for Controllers
	}
	
	ObjectMapper mapper = new ObjectMapper();
	Gson gson = new Gson();
	
	RestTemplate rt = new RestTemplate();
	
	public SpoonacularIntegration getSpoonacularAPI() {
		return spoonacularAPI;
	}
	
//	WeekResponse weekMeals = mapper.readValues(spoonacularAPI.getWeekMeals(rt), WeekResponse.class);
//	String weekMeals = gson.toString();
//	String dayMeals = gson.toString();
	
	public void setSpoonacularAPI(SpoonacularIntegration spoonacularAPI) {
		this.spoonacularAPI = spoonacularAPI;
	}
}
