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
	
	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals() {
//			@RequestParam("numCalories") String numCalories, 
//			@RequestParam("diet") String diet, 
//			@RequestParam("exclusions") String exclusions) {
		RestTemplate rt = new RestTemplate();
		WeekResponse weekMeals = apiService.getSpoonacularAPI().getWeekMeals(rt);
		return ResponseEntity.ok(weekMeals);
		
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals() {
//			@RequestParam("numCalories") String numCalories, 
//			@RequestParam("diet") String diet, 
//			@RequestParam("exclusions") String exclusions) {
		RestTemplate rt = new RestTemplate();
		DayResponse dayMeals = apiService.getSpoonacularAPI().getDayMeals(rt);
		return ResponseEntity.ok(dayMeals);
		
	}
}
