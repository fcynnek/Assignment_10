package com.fcynnek.Assignment_10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SpoonacularApiResponse {

	@JsonProperty("week")
	private Week week;

	/*
	 * For daily responses:
	 * Stored directly under meals and nutrients DTO classes
	 */
	
	
	
	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	
	
}
