package com.fcynnek.Assignment_10.api;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fcynnek.Assignment_10.dto.DayResponse;
import com.fcynnek.Assignment_10.dto.WeekResponse;

public class SpoonacularIntegration {
	
	RestTemplate rt = new RestTemplate();
		
		/*
		 *  API Key from Spoonacular:
		 *  f86c8e27d2b84f2fac40c3c0974a933f 
		 * 
		 *  Requests: Generate a meal plan with three meals per day (breakfast, lunch, and dinner).
		 *  https://api.spoonacular.com/mealplanner/generate
		 *  
		 *  Response Headers: 
		 *  Content-Type: application/json
		 *  
		 *  Parameters:
		 *  timeFrame		<String>			"day"	/ 	"week"
		 *  targetCalories	<Integer>		# numeric value #
		 *  diet			<String>			https://spoonacular.com/food-api/docs#Diets
		 *  exclude			<String>			Example: shellfish, olives
		 */
	
	public DayResponse getDayMeals(RestTemplate rt, String numCalories, String diet, String exclusions) {
		UriComponentsBuilder uriBuild = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
										.queryParam("apiKey", "f86c8e27d2b84f2fac40c3c0974a933f")
										.queryParam("timeFrame", "day");
		if(numCalories != null) {
			uriBuild.queryParam("targetCalories", numCalories);
		}
		if(diet != null) {
			uriBuild.queryParam("diet", diet);
		}
		if(exclusions != null) {
			uriBuild.queryParam("exclude", exclusions);
		}
		
		URI uri = uriBuild.build().toUri();
		ResponseEntity<DayResponse> dayMeals = rt.getForEntity(uri, DayResponse.class);
		return dayMeals.getBody();
	}
	
	public WeekResponse getWeekMeals(RestTemplate rt, String numCalories, String diet, String exclusions) {
		UriComponentsBuilder uriBuild = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
										.queryParam("apiKey", "f86c8e27d2b84f2fac40c3c0974a933f")
										.queryParam("timeFrame", "week");
		if(numCalories != null) {
			uriBuild.queryParam("targetCalories", numCalories);
		}
		if(diet != null) {
			uriBuild.queryParam("diet", diet);
		}
		if(exclusions != null) {
			uriBuild.queryParam("exclude", exclusions);
		}
		
		URI uri = uriBuild.build().toUri();
		ResponseEntity<WeekResponse> weekMeals = rt.getForEntity(uri, WeekResponse.class);
		return weekMeals.getBody();
	}
	
	public DayResponse getDayResponse() {
		return null;
	}

}
