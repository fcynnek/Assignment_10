package com.fcynnek.Assignment_10.dto;

import java.util.List;

public class Week {

	private List<Meals> meals;
	private Nutrients nutrients;
	
	
	
	public List<Meals> getMeals() {
		return meals;
	}
	public Nutrients getNutrients() {
		return nutrients;
	}
	
	
	
	public void setMeals(List<Meals> meals) {
		this.meals = meals;
	}
	public void setNutrients(Nutrients nutrients) {
		this.nutrients = nutrients;
	}
	
}
