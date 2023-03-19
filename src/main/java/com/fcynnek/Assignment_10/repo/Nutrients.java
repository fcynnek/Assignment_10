package com.fcynnek.Assignment_10.repo;

public class Nutrients {

	private Double calories;
	private Double protein;
	private Double fat;
	private Double carbohydrates;

	
	
	@Override
	public String toString() {
		return "Nutrients [calories=" + calories + ", protein=" + protein + ", fat=" + fat + ", carbohydrates="
				+ carbohydrates + "]";
	}
	
	
	
	public Double getCalories() {
		return calories;
	}
	public Double getProtein() {
		return protein;
	}
	public Double getFat() {
		return fat;
	}
	public Double getCarbohydrates() {
		return carbohydrates;
	}
	
	
	
	public void setCalories(Double calories) {
		this.calories = calories;
	}
	public void setProtein(Double protein) {
		this.protein = protein;
	}
	public void setFat(Double fat) {
		this.fat = fat;
	}
	public void setCarbohydrates(Double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}
	
}
