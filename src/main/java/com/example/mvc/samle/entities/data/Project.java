package com.example.mvc.samle.entities.data;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.validator.constraints.NotBlank;

public class Project {

	private Long projectId;

	private String name;

	@NotBlank(message = "The description of the project should be not null.")
	private String description;

	private Sponsor sponsor;

	private BigDecimal authorizedHours;

	private BigDecimal authorizedFunds;

	private String year;

	private List<String> personOfContact;

	private boolean special;

	private List<String> type;

	private List<String> favouriteLanguage;

	private List<String> favouritePhrases;

	private List<Country> countries;

	public List<String> getFavouritePhrases() {
		return favouritePhrases;
	}

	public void setFavouritePhrases(List<String> favouritePhrases) {
		this.favouritePhrases = favouritePhrases;
	}

	public List<String> getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(List<String> favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("Spring databinds the name");
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getAuthorizedHours() {
		return authorizedHours;
	}

	public void setAuthorizedHours(BigDecimal authorizedHours) {
		this.authorizedHours = authorizedHours;
	}

	public BigDecimal getAuthorizedFunds() {
		return authorizedFunds;
	}

	public void setAuthorizedFunds(BigDecimal authorizedFunds) {
		this.authorizedFunds = authorizedFunds;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public boolean isSpecial() {
		return special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public List<String> getType() {
		return type;
	}

	public void setType(List<String> type) {
		this.type = type;
	}

	public Sponsor getSponsor() {
		return sponsor;
	}

	public void setSponsor(Sponsor sponsor) {
		this.sponsor = sponsor;
	}

	public List<String> getPersonOfContact() {
		return personOfContact;
	}

	public void setPersonOfContact(List<String> personOfContact) {
		this.personOfContact = personOfContact;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", description=" + description + ", sponsor="
				+ sponsor + ", authorizedHours=" + authorizedHours + ", authorizedFunds=" + authorizedFunds + ", year="
				+ year + ", personOfContact=" + personOfContact + ", special=" + special + ", type=" + type
				+ ", favouriteLanguage=" + favouriteLanguage + ", countries=" + countries + "]";
	}

}