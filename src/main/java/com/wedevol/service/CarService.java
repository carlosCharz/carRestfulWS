package com.wedevol.service;

import java.util.List;

import com.wedevol.bean.Car;
import com.wedevol.exception.ErrorException;

public interface CarService {
	
	public List<Car> getCars() throws Exception;
	
	public Car getCar(Integer id) throws ErrorException;
	
	public void createCar(Car car) throws ErrorException;
	
	public void updateCar(Car car) throws Exception;
	
	public void deleteCar(int id) throws Exception;

}
