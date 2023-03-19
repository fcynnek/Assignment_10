package com.fcynnek.Assignment_10.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WeekResponse {

	private DayResponse monday;
	private DayResponse tuesday;
	private DayResponse wednesday;
	private DayResponse thursday;
	private DayResponse friday;
	private DayResponse saturday;
	private DayResponse sunday;
	
	
	
	public DayResponse getMonday() {
		return monday;
	}
	public DayResponse getTuesday() {
		return tuesday;
	}
	public DayResponse getWednesday() {
		return wednesday;
	}
	public DayResponse getThursday() {
		return thursday;
	}
	public DayResponse getFriday() {
		return friday;
	}
	public DayResponse getSaturday() {
		return saturday;
	}
	public DayResponse getSunday() {
		return sunday;
	}
	
	
	
	public void setMonday(DayResponse monday) {
		this.monday = monday;
	}
	public void setTuesday(DayResponse tuesday) {
		this.tuesday = tuesday;
	}
	public void setWednesday(DayResponse wednesday) {
		this.wednesday = wednesday;
	}
	public void setThursday(DayResponse thursday) {
		this.thursday = thursday;
	}
	public void setFriday(DayResponse friday) {
		this.friday = friday;
	}
	public void setSaturday(DayResponse saturday) {
		this.saturday = saturday;
	}
	public void setSunday(DayResponse sunday) {
		this.sunday = sunday;
	}	
	
}
