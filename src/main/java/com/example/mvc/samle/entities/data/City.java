package com.example.mvc.samle.entities.data;

public class City {
	private String cityName;
	
	public City(String cityName) {
		super();
		this.cityName = cityName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
