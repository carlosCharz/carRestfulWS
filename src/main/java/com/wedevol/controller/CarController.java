package com.wedevol.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wedevol.bean.Car;
import com.wedevol.bean.CarsResponse;
import com.wedevol.bean.StateResponse;
import com.wedevol.service.CarService;
import com.wedevol.util.Util;

@Controller
@RequestMapping("/restapp")
public class CarController {

	private static final Logger logger = LoggerFactory
			.getLogger(CarController.class);

	@Autowired
	private CarService carService;

	@RequestMapping(value = "/cars", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody
	CarsResponse getCars() {

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

	@RequestMapping(value = "/car/create", method = RequestMethod.POST, produces = "application/json; charset=utf-8")
	public @ResponseBody
	StateResponse createCar(@RequestBody Car request) {

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
}
