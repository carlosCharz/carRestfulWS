package com.wedevol.mybatis.mapper;

import java.util.List;

import com.wedevol.bean.Car;

public interface CarMapper {

    public List<Car> getCars();
    
    public Car getCarById(int id);
    
    public int createCar(Car car);
    
    public int updateCar(Car car);
    
    public int deleteCarById(int id);
    
}