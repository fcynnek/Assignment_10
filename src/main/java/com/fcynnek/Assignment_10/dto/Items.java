package com.fcynnek.Assignment_10.dto;

public class Items {

	private Long id;
	private Integer slot;
	private Integer position;
	private String type;
	private Value value;
	
	
	
	public Long getId() {
		return id;
	}
	public Integer getSlot() {
		return slot;
	}
	public Integer getPosition() {
		return position;
	}
	public String getType() {
		return type;
	}
	public Value getValue() {
		return value;
	}
	
	
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setSlot(Integer slot) {
		this.slot = slot;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setValue(Value value) {
		this.value = value;
	}
	
}
