package com.fcynnek.Assignment_10.web;

import org.springframework.web.bind.annotation.GetMapping;

import com.fcynnek.Assignment_10.dto.ResponseEntity;

public class MealController {

	@GetMapping("mealplanner/week")
	public ResponseEntity<WeekResponse> getWeekMeals(String numCalories, String diet, String exclusions) {
		
	}

	@GetMapping("mealplanner/day")
	public ResponseEntity<DayResponse> getDayMeals(String numCalories, String diet, String exclusions) {
		
	}
}
