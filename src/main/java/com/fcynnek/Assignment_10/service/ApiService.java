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

//	private String numCalories = null;
//	private String diet = null;
//	private String exclusions = null;
	
	
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
		ObjectMapper mapper = new ObjectMapper();
		
		
		JsonArray mondayMealsArray = weeksObj.getAsJsonObject("monday").getAsJsonArray("meals");
//		DayResponse mondayResponse = parseAndSetMealsAndNutrients(weekResponse, mondayMealsArray);
//		weekResponse = mapper.readValues(mondayMealsArray, WeekResponse.class);
		parseAndSetMealsAndNutrients(weekResponse, mondayMealsArray);
//		Week.setMonday().setMeals(mondayResponse.setMeals());
//	    weekResponse.getMonday().setNutrients(mondayResponse.getNutrients());
		
		JsonArray tuesdayMealsArray = weeksObj.getAsJsonObject("tuesday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, tuesdayMealsArray);
		
		JsonArray wednesdayMealsArray = weeksObj.getAsJsonObject("wednesday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, wednesdayMealsArray);
		
		JsonArray thursdayMealsArray = weeksObj.getAsJsonObject("thursday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, thursdayMealsArray);
		
		JsonArray fridayMealsArray = weeksObj.getAsJsonObject("friday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, fridayMealsArray);
		
		JsonArray saturdayMealsArray = weeksObj.getAsJsonObject("saturday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, saturdayMealsArray);
		
		JsonArray sundayMealsArray = weeksObj.getAsJsonObject("sunday").getAsJsonArray("meals");
		parseAndSetMealsAndNutrients(weekResponse, sundayMealsArray);
		
		return weekResponse;
		
		
	}



	private WeekResponse parseAndSetMealsAndNutrients(WeekResponse weekResponse, JsonArray mealsArray) {
		
		JsonObject jsonObject = gson.fromJson(gson.toJson(weekResponse), JsonObject.class);
		JsonObject weeksObj = jsonObject.getAsJsonObject("week");
//		JsonArray mealsArray = weeksObj.getAsJsonArray("meals");
		DayResponse dayResponse = new DayResponse();
		List<Meals> parsedMeals = new ArrayList<>();
		
//		JsonElement weekObj = weeksObj.get("monday");
		Week week = new Week();
		for (JsonElement weekDay : mealsArray) {
			JsonObject weekObj = weeksObj.getAsJsonObject();
//			ObjectMapper mapper = new ObjectMapper();
//			weekResponse = mapper.readValues(weekObj, WeekResponse.class);
			weekResponse.setWeek(week);
		}
		
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
		
		JsonObject nutrientObject = weeksObj.getAsJsonObject("nutrients");
		
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
		return weekResponse;
		
	}
	
}
