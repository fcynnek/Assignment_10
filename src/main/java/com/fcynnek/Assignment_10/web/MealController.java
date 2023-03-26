package com.fcynnek.Assignment_10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fcynnek.Assignment_10.dto.DayResponse;
import com.fcynnek.Assignment_10.dto.WeekResponse;
import com.fcynnek.Assignment_10.service.ApiService;

@RestController
public class MealController {

	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private ApiService apiService;
	
	RestTemplate rt = new RestTemplate();
	
	//String numCalories, String diet, String exclusions) {
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(
			@RequestParam(value="numCalories", required=false) String numCalories, 
			@RequestParam(value="diet", required=false) String diet, 
			@RequestParam(value="exclusions", required=false) String exclusions) {
		
		ApiService apiService = appContext.getBean(ApiService.class);
		WeekResponse weekResponse = apiService.getWeekMeals();
		return ResponseEntity.ok(weekResponse);
		
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(
			@RequestParam(value="numCalories", required=false) String numCalories, 
			@RequestParam(value="diet", required=false) String diet, 
			@RequestParam(value="exclusions", required=false) String exclusions) {
		
		ApiService apiService = appContext.getBean(ApiService.class);
		DayResponse dayResponse = apiService.getDayMeals();
		return ResponseEntity.ok(dayResponse);
		
	}
}
