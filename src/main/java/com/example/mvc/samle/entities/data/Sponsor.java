package com.example.mvc.samle.entities.data;

public class Sponsor {
	private String name;
	private String organization;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Sponsor [name=" + name + ", organization=" + organization + ", email=" + email + "]";
	}
}
