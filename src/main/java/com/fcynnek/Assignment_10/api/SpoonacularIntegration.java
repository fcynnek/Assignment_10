package com.fcynnek.Assignment_10.api;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fcynnek.Assignment_10.dto.DayResponse;

public class SpoonacularIntegration {

	/* 
	* API Key from Spoonacular:
	* f86c8e27d2b84f2fac40c3c0974a933f 
	*/
	
	public void callSpoonacularApi() {
		RestTemplate rt = new RestTemplate();
		
		
		URI uri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/716429/information")
										.queryParam("apiKey", "f86c8e27d2b84f2fac40c3c0974a933f")
										.build()
										.toUri();
		
		// Request Example:
		// https://api.spoonacular.com/recipes/extract?
		// url=https://foodista.com/recipe/ZHK4KPB6/chocolate-crinkle-cookies
		
		// https://api.spoonacular.com/mealplanner/{username}/week/{start-date}
		
		// https://api.spoonacular.com/mealplanner/{username}/day/{date}
		ResponseEntity<DayResponse> dayMeals = rt.getForEntity(uri, DayResponse.class);
		
	}
}
