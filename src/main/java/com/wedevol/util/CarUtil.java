package com.wedevol.util;

import java.util.ArrayList;
import java.util.List;

import com.wedevol.bean.*;

public class CarUtil {

	public static List<Car> getListOfCarsMock() {
		List<Car> carList = new ArrayList<Car>();
		Car car1 = new Car();
		car1.setId(1);
		car1.setModel("Rav4");
		car1.setYear(2016);
		car1.setManufacturer("Toyota");
		car1.setCountry("Japan");
		Car car2 = new Car();
		car2.setId(2);
		car2.setModel("Yaris");
		car2.setYear(2015);
		car2.setManufacturer("Toyota");
		car2.setCountry("Korea");

		carList.add(car1);
		carList.add(car2);

		return carList;
	}

	public static Car getCarMock() {
		Car car1 = new Car();
		car1.setId(1);
		car1.setModel("Rav4");
		car1.setYear(2016);
		car1.setManufacturer("Toyota");
		car1.setCountry("Japan");
		return car1;
	}
}
