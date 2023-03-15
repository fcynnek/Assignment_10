package com.fcynnek.Assignment_10.dto;

public class Nutrients {

	private String name;
	private Integer amount;
	private String unit;
	private Integer percentOfDailyNeeds;
	
	
	
	public String getName() {
		return name;
	}
	public Integer getAmount() {
		return amount;
	}
	public String getUnit() {
		return unit;
	}
	public Integer getPercentOfDailyNeeds() {
		return percentOfDailyNeeds;
	}
	
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public void setPercentOfDailyNeeds(Integer percentOfDailyNeeds) {
		this.percentOfDailyNeeds = percentOfDailyNeeds;
	}
	
}
