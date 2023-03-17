package com.fcynnek.Assignment_10.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_10.api.SpoonacularIntegration;
import com.fcynnek.Assignment_10.dto.WeekResponse;

@Service
public class ApiService {

	SpoonacularIntegration spoonacularAPI = new SpoonacularIntegration();
	
	public ApiService() {
		// for Controllers
	}
	
	ObjectMapper mapper = new ObjectMapper();
	
	RestTemplate rt = new RestTemplate();
	
	public SpoonacularIntegration getSpoonacularAPI() {
		return spoonacularAPI;
	}
	
	WeekResponse weekMeals = mapper.readValues(spoonacularAPI.getWeekMeals(rt), WeekResponse.class);
	
	public void setSpoonacularAPI(SpoonacularIntegration spoonacularAPI) {
		this.spoonacularAPI = spoonacularAPI;
	}
}
