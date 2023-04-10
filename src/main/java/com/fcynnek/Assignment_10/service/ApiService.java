package com.fcynnek.Assignment_10.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fcynnek.Assignment_10.api.SpoonacularIntegration;
import com.fcynnek.Assignment_10.dto.DayResponse;
import com.fcynnek.Assignment_10.dto.Week;
import com.fcynnek.Assignment_10.dto.WeekResponse;
import com.fcynnek.Assignment_10.repo.Meals;
import com.fcynnek.Assignment_10.repo.Nutrients;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class ApiService {

	SpoonacularIntegration spoonacularAPI = new SpoonacularIntegration();
	
	public ApiService() {
		// for Controllers
	}
	
	Gson gson = new Gson();
	
	RestTemplate rt = new RestTemplate();

//	private String numCalories = null;
//	private String diet = null;
//	private String exclusions = null;
	
	
	public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
		DayResponse dayResponse = spoonacularAPI.getDayMeals(rt, numCalories, diet, exclusions);
		
		JsonObject dayObject = gson.fromJson(gson.toJson(dayResponse), JsonObject.class);
		JsonArray mealsArray = dayObject.getAsJsonArray("meals");
		
		List<Meals> parsedMeals = new ArrayList<>();
		
		for (JsonElement mealElement : mealsArray) {
			JsonObject mealsObject = mealElement.getAsJsonObject();
			
			Long id = mealsObject.get("id").getAsLong();
			String imageType = mealsObject.get("imageType").getAsString();
			String title = mealsObject.get("title").getAsString();
			Integer readyInMinutes = mealsObject.get("readyInMinutes").getAsInt();
			Integer servings = mealsObject.get("servings").getAsInt();
			String sourceUrl = mealsObject.get("sourceUrl").getAsString();
			
			Meals parsedMeal = new Meals();
			parsedMeal.setId(id);
			parsedMeal.setImageType(imageType);
			parsedMeal.setTitle(title);
			parsedMeal.setReadyInMinutes(readyInMinutes);
			parsedMeal.setServings(servings);
			parsedMeal.setSourceUrl(sourceUrl);
			
			parsedMeals.add(parsedMeal);
		}
		// fix this to parse the nutrients and set them
		// then extract into its own method
		//then call this 7 times for the week
		Nutrients nutrients = dayResponse.getNutrients();
		
		Double calories = nutrients.getCalories();
		Double protein = nutrients.getProtein();
		Double fat = nutrients.getFat();
		Double carbohydrates = nutrients.getCarbohydrates();
		
		Nutrients parsedNutrients = new Nutrients();
		parsedNutrients.setCalories(calories);
		parsedNutrients.setProtein(protein);
		parsedNutrients.setFat(fat);
		parsedNutrients.setCarbohydrates(carbohydrates);
		
		dayResponse.setMeals(parsedMeals);
		dayResponse.setNutrients(parsedNutrients);
		
		return dayResponse;
	}


	
	public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
		WeekResponse weekResponse = spoonacularAPI.getWeekMeals(rt, numCalories, diet, exclusions);
		
		JsonObject jsonObject = gson.fromJson(gson.toJson(weekResponse), JsonObject.class);
		JsonObject weeksObj = jsonObject.getAsJsonObject("week");
//		JsonArray mealsArray = jsonObject.getAsJsonArray("week");
		
		
		List<Meals> parsedMeals = new ArrayList<>();
		
		JsonArray mondayMealsArray = weeksObj.getAsJsonObject("monday").getAsJsonArray("meals");
		
		for (JsonElement mealElement : mealsArray) {
			JsonObject mealsObject = mealElement.getAsJsonObject();
			
			Long id = mealsObject.get("id").getAsLong();
			String imageType = mealsObject.get("imageType").getAsString();
			String title = mealsObject.get("title").getAsString();
			Integer readyInMinutes = mealsObject.get("readyInMinutes").getAsInt();
			Integer servings = mealsObject.get("servings").getAsInt();
			String sourceUrl = mealsObject.get("sourceUrl").getAsString();
			
			Meals parsedMeal = new Meals();
			parsedMeal.setId(id);
			parsedMeal.setImageType(imageType);
			parsedMeal.setTitle(title);
			parsedMeal.setReadyInMinutes(readyInMinutes);
			parsedMeal.setServings(servings);
			parsedMeal.setSourceUrl(sourceUrl);
			
			parsedMeals.add(parsedMeal);
		}
		DayResponse dayResponse = new DayResponse();
		Nutrients nutrients = dayResponse.getNutrients();
		
		Double calories = nutrients.getCalories();
		Double protein = nutrients.getProtein();
		Double fat = nutrients.getFat();
		Double carbohydrates = nutrients.getCarbohydrates();
		
		Nutrients parsedNutrients = new Nutrients();
		parsedNutrients.setCalories(calories);
		parsedNutrients.setProtein(protein);
		parsedNutrients.setFat(fat);
		parsedNutrients.setCarbohydrates(carbohydrates);
		
		dayResponse.setMeals(parsedMeals);
		dayResponse.setNutrients(parsedNutrients);
		
		return weekResponse;
		
		
	}
	
}
