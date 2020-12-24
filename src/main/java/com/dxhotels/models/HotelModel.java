package com.dxhotels.models;

public class HotelModel {

	private String name;
	private double valuePerNight;
	
	public HotelModel(String name, double valuePerNight) {
		this.name = name;
		this.valuePerNight = valuePerNight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getValuePerNight() {
		return valuePerNight;
	}

	public void setValuePerNight(double valuePerNight) {
		this.valuePerNight = valuePerNight;
	}
	
	
	
	
}
