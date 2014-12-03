package com.wedevol.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedevol.bean.Car;
import com.wedevol.bean.CarResponse;
import com.wedevol.bean.CarsResponse;
import com.wedevol.bean.StateResponse;
import com.wedevol.service.CarService;
import com.wedevol.util.Util;

@Controller
@RequestMapping("/car")
public class CarController {

	private static final Logger logger = LoggerFactory
			.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	/* Get list of cars */
	/* 
	 * http://localhost:8080/carRestfulWS/car/list 
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody CarsResponse getListCars() {

		CarsResponse response = new CarsResponse();
		List<Car> list;

		try {
			list = carService.getCars();
			response.setCars(list);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);

		} catch (Exception e) {
			response.setCars(null);
			response.setCode(Util.ERROR_CODE);
			response.setMessage(Util.ERROR_MESSAGE + ": " + e.getMessage());
			logger.error(Util.ERROR_MESSAGE + ": " + e.getMessage());
		}
		return response;
	}
	
	/* Get a car */
	/* 
	 * http://localhost:8080/carRestfulWS/car/1 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody CarResponse getCar(@PathVariable("id") int id) {

		CarResponse response = new CarResponse();
		Car car;

		try {
			car = carService.getCar(id);
			response.setCar(car);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);

		} catch (Exception e) {
			response.setCar(null);
			response.setCode(Util.ERROR_CODE);
			response.setMessage(Util.ERROR_MESSAGE + ": " + e.getMessage());
			logger.error(Util.ERROR_MESSAGE + ": " + e.getMessage());
		}
		return response;
	}

	/* Create a car */
	/* 
	 * http://localhost:8080/carRestfulWS/car/create 
	 * {"model": "Yaris2","year": 2014,"manufacturer": "Toyota","country": "Japan"} 
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse createCar(@RequestBody Car request) {

		StateResponse response = new StateResponse();

		try {
			carService.createCar(request);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
		} catch (Exception e) {
			response.setCode(Util.ERROR_CODE);
			response.setMessage(Util.ERROR_MESSAGE + ": " + e.getMessage());
			logger.error(Util.ERROR_MESSAGE + ": " + e.getMessage());
		}
		return response;
	}

	/* Update a car */
	/* 
	 * http://localhost:8080/carRestfulWS/car/6 
	 * {"model": "Yaris3","year": 2015,"manufacturer": "Toyota","country": "Japan"} 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse updateCar(@PathVariable("id") int id,
			@RequestBody Car request) {

		StateResponse response = new StateResponse();
		request.setId(id);

		try {
			carService.updateCar(request);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
		} catch (Exception e) {
			response.setCode(Util.ERROR_CODE);
			response.setMessage(Util.ERROR_MESSAGE + ": " + e.getMessage());
			logger.error(Util.ERROR_MESSAGE + ": " + e.getMessage());
		}
		return response;

	}

	/* Delete a car */
	/* 
	 * http://localhost:8080/carRestfulWS/car/6 
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = "application/json; charset=utf-8")
	public @ResponseBody StateResponse deleteCar(@PathVariable("id") int id) {

		StateResponse response = new StateResponse();

		try {
			carService.deleteCar(id);
			response.setCode(Util.OK_CODE);
			response.setMessage(Util.OK_MESSAGE);
		} catch (Exception e) {
			response.setCode(Util.ERROR_CODE);
			response.setMessage(Util.ERROR_MESSAGE + ": " + e.getMessage());
			logger.error(Util.ERROR_MESSAGE + ": " + e.getMessage());
		}
		return response;
	}
}
