package com.wedevol.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wedevol.bean.Car;
import com.wedevol.exception.CarServerErrorException;
import com.wedevol.exception.ErrorException;
import com.wedevol.exception.CarNotFoundException;
import com.wedevol.mybatis.mapper.CarMapper;
import com.wedevol.service.CarService;

@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private CarMapper carMapper;

	@Override
	public List<Car> getCars() throws Exception {
		return carMapper.getCars();
	}

	@Override
	public Car getCar(Integer id) throws ErrorException {
		try {
			final Car car = carMapper.getCarById(Integer.valueOf(id));
			if (car == null) {
				throw new CarNotFoundException();
			} else {
				return car;
			}
		}catch(CarNotFoundException e){
			throw new CarNotFoundException();
		}catch(Exception e){
			throw new CarServerErrorException();
		}
	}

	@Override
	public void createCar(final Car car) throws Exception {
		carMapper.createCar(car);
	}

	@Override
	public void updateCar(final Car car) throws Exception {
		carMapper.updateCar(car);
	}

	@Override
	public void deleteCar(int id) throws Exception {
		carMapper.deleteCarById(id);
	}

}
