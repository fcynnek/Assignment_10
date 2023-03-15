package com.fcynnek.Assignment_10.dto;

public class Meals {

	private Long id;
	private String imageType;
	private String title;
	private Integer readyInMinutes;
	private Integer servings;
	private String sourceUrl;
	
	
	
	public Long getId() {
		return id;
	}
	public String getImageType() {
		return imageType;
	}
	public String getTitle() {
		return title;
	}
	public Integer getReadyInMinutes() {
		return readyInMinutes;
	}
	public Integer getServings() {
		return servings;
	}
	public String getSourceUrl() {
		return sourceUrl;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setReadyInMinutes(Integer readyInMinutes) {
		this.readyInMinutes = readyInMinutes;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public void setSourceUrl(String sourceUrl) {
		this.sourceUrl = sourceUrl;
	}
	
}
