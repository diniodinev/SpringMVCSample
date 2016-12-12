package com.example.mvc.samle.entities.data;

import java.util.LinkedList;
import java.util.List;

public class Country {
	private String name;

	private List<City> cities;

	public Country(String name) {
		super();
		this.name = name;
		cities = new LinkedList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public void add(City city) {
		this.cities.add(city);
	}

}
