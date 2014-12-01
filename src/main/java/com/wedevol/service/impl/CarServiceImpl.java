package com.wedevol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedevol.bean.Car;
import com.wedevol.mybatis.mapper.CarMapper;
import com.wedevol.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;

	public List<Car> getCars() throws Exception {
		return carMapper.getCars();
	}

	public void updateCar(final Car car) throws Exception {
		carMapper.updateCarById(car);
	}

	public void createCar(Car car) throws Exception {
		carMapper.createCar(car);
	}

}
