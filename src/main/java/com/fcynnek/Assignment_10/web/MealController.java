package com.fcynnek.Assignment_10.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcynnek.Assignment_10.dto.DayResponse;
import com.fcynnek.Assignment_10.service.ApiService;

@RestController
public class MealController {

	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	private ApiService apiService;
	
//	@GetMapping("mealplanner/week")
//	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
//		
//	}
//
	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		return null;
		
	}
}
