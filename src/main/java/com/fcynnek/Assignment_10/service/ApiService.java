package com.fcynnek.Assignment_10.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
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
	
	
	public DayResponse getDayMeals(String numCalories, String diet, String exclusions) {
		DayResponse dayResponse = spoonacularAPI.getDayMeals(rt, numCalories, diet, exclusions);
		JsonObject dayObj = gson.fromJson(gson.toJson(dayResponse), JsonObject.class);
		JsonArray mealsArray = dayObj.getAsJsonArray("meals");
		
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
		
		JsonObject nutrientObject = dayObj.getAsJsonObject("nutrients");
		
		Double calories = nutrientObject.get("calories").getAsDouble();
		Double protein = nutrientObject.get("protein").getAsDouble();
		Double fat = nutrientObject.get("fat").getAsDouble();
		Double carbohydrates = nutrientObject.get("carbohydrates").getAsDouble();
		
		Nutrients parsedNutrient = new Nutrients();
		parsedNutrient.setCalories(calories);
		parsedNutrient.setProtein(protein);
		parsedNutrient.setFat(fat);
		parsedNutrient.setCarbohydrates(carbohydrates);
				
		dayResponse.setMeals(parsedMeals);
		
		return dayResponse;
	}

	
	public WeekResponse getWeekMeals(String numCalories, String diet, String exclusions) {
		WeekResponse weekResponse = spoonacularAPI.getWeekMeals(rt, numCalories, diet, exclusions);
		JsonObject jsonObject = gson.fromJson(gson.toJson(weekResponse), JsonObject.class);
		JsonObject weeksObj = jsonObject.getAsJsonObject("week");
		Week week = new Week();
		
		DayResponse mondayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("monday"));
		week.setMonday(mondayResponse);
		
		DayResponse tuesdayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("tuesday"));
		week.setTuesday(tuesdayResponse);
		
		DayResponse wednesdayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("wednesday"));
		week.setWednesday(wednesdayResponse);
		
		DayResponse thursdayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("thursday"));
		week.setThursday(thursdayResponse);
		
		DayResponse fridayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("friday"));
		week.setFriday(fridayResponse);
		
		DayResponse saturdayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("saturday"));
		week.setSaturday(saturdayResponse);
		
		DayResponse sundayResponse = parseAndSetMealsAndNutrients(weeksObj.getAsJsonObject("sunday"));
		week.setSunday(sundayResponse);
		
		weekResponse.setWeek(week);
		
		return weekResponse;
		
	}


	private DayResponse parseAndSetMealsAndNutrients(JsonObject dayObj) {
		JsonArray mealsArray = dayObj.getAsJsonArray("meals");
		
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
		
		JsonObject nutrientObject = dayObj.getAsJsonObject("nutrients");
		
		Double calories = nutrientObject.get("calories").getAsDouble();
		Double protein = nutrientObject.get("protein").getAsDouble();
		Double fat = nutrientObject.get("fat").getAsDouble();
		Double carbohydrates = nutrientObject.get("carbohydrates").getAsDouble();
		
		Nutrients parsedNutrient = new Nutrients();
		parsedNutrient.setCalories(calories);
		parsedNutrient.setProtein(protein);
		parsedNutrient.setFat(fat);
		parsedNutrient.setCarbohydrates(carbohydrates);
				
		DayResponse dayResponse = new DayResponse();
		dayResponse.setMeals(parsedMeals);
		dayResponse.setNutrients(parsedNutrient);
		
		return dayResponse;
		
	}
	
}
