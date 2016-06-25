package com.wedevol.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CarsResponse extends StateResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@JsonProperty("cars")
	private List<Car> cars;

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
}
