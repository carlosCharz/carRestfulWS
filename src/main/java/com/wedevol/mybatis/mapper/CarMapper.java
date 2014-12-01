package com.wedevol.mybatis.mapper;

import java.util.List;

import com.wedevol.bean.Car;

public interface CarMapper {

    public List<Car> getCars();
    
    public int updateCarById(Car car);
    
    public int createCar(Car car);
    
}