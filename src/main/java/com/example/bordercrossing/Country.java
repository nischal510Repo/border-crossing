package com.example.bordercrossing;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
	
	private String cca3;
	private Set<String> borders;

	public String getCca3() {
		return cca3;
	}
	public void setCca3(String cca3) {
		this.cca3 = cca3;
	}
	public Set<String> getBorders() {
		return borders;
	}
	public void setBorders(Set<String> borders) {
		this.borders = borders;
	}
	public Country(String cca3, Set<String> borders) {
		super();
		this.cca3 = cca3;
		this.borders = borders;
	}
	public Country() {
		super();
	}
	

	

}
