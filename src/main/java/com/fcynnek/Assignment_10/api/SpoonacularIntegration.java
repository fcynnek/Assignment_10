package com.fcynnek.Assignment_10.api;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fcynnek.Assignment_10.dto.DayResponse;
import com.fcynnek.Assignment_10.dto.WeekResponse;

public class SpoonacularIntegration {

	/* 
	* API Key from Spoonacular:
	* f86c8e27d2b84f2fac40c3c0974a933f 
	*/
	
//	@Test
	public void callSpoonacularApi() {
		RestTemplate rt = new RestTemplate();
		
		
//		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/716429/information")
		URI uriDay = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/mealplanner/generate")
										.queryParam("apiKey", "f86c8e27d2b84f2fac40c3c0974a933f")
										.build()
										.toUri();
		
		/*
		 *  Requests: Generate a meal plan with three meals per day (breakfast, lunch, and dinner).
		 *  https://api.spoonacular.com/mealplanner/generate
		 *  
		 *  Response Headers: 
		 *  Content-Type: application/json
		 *  
		 *  Parameters
		 *  timeFrame		<String>			"day"	/ 	"week"
		 *  targetCalories	<Integer>		# numeric value #
		 *  diet			<String>			https://spoonacular.com/food-api/docs#Diets
		 *  exclude			<String>			Example: shellfish, olives
		 */
		
		ResponseEntity<DayResponse> dayMeals = rt.getForEntity(uri, DayResponse.class);
		System.out.println(dayMeals);
		
//		ResponseEntity<WeekResponse> weekMeals = rt.getForEntity(uri, WeekResponse.class);
		
	}
}
