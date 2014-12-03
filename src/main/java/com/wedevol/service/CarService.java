package com.wedevol.service;

import java.util.List;

import com.wedevol.bean.Car;

public interface CarService {
	
	public List<Car> getCars() throws Exception;
	
	public Car getCar(int id) throws Exception;
	
	public void createCar(Car car) throws Exception;
	
	public void updateCar(Car car) throws Exception;
	
	public void deleteCar(int id) throws Exception;

}
