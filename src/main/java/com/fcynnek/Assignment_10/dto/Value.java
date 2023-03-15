package com.fcynnek.Assignment_10.dto;

public class Value {

	private Integer servings;
	private Long id;
	private String title;
	private String image;
	private String imageType;
	
	
	
	public Integer getServings() {
		return servings;
	}
	public Long getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getImage() {
		return image;
	}
	public String getImageType() {
		return imageType;
	}
	
	
	
	public void setServings(Integer servings) {
		this.servings = servings;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setImageType(String imageType) {
		this.imageType = imageType;
	}
	
}
