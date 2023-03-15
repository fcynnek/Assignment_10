package com.fcynnek.Assignment_10.dto;

public class DayResponse {

	private Nutrients nutritionSummary;
	private Nutrients nutritionSummaryBreakfast;
	private Nutrients nutritionSummaryLunch;
	private Nutrients nutritionSummaryDinner;
	private Long date;
	private String day;
	private Items items;
	
	
	
	public Nutrients getNutritionSummary() {
		return nutritionSummary;
	}
	public Nutrients getNutritionSummaryBreakfast() {
		return nutritionSummaryBreakfast;
	}
	public Nutrients getNutritionSummaryLunch() {
		return nutritionSummaryLunch;
	}
	public Nutrients getNutritionSummaryDinner() {
		return nutritionSummaryDinner;
	}
	public Long getDate() {
		return date;
	}
	public String getDay() {
		return day;
	}
	public Items getItems() {
		return items;
	}
	
	
	
	public void setNutritionSummary(Nutrients nutritionSummary) {
		this.nutritionSummary = nutritionSummary;
	}
	public void setNutritionSummaryBreakfast(Nutrients nutritionSummaryBreakfast) {
		this.nutritionSummaryBreakfast = nutritionSummaryBreakfast;
	}
	public void setNutritionSummaryLunch(Nutrients nutritionSummaryLunch) {
		this.nutritionSummaryLunch = nutritionSummaryLunch;
	}
	public void setNutritionSummaryDinner(Nutrients nutritionSummaryDinner) {
		this.nutritionSummaryDinner = nutritionSummaryDinner;
	}
	public void setDate(Long date) {
		this.date = date;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	
}
