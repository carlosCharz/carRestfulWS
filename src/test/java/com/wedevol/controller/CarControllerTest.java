package com.wedevol.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wedevol.bean.Car;
import com.wedevol.bean.CarsResponse;
import com.wedevol.service.CarService;
import com.wedevol.util.Util;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("/servlet-context.xml")
@WebAppConfiguration
public class CarControllerTest {

	@Mock
	private CarService carServiceMock;

	@InjectMocks
	private CarController carController = new CarController();

	private MockMvc mockMvc;
	
	@Before
	public void init(){
		mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
	}

	@Test
	public void getListCars_ShouldReturnFoundCars() throws Exception {

		CarsResponse response = new CarsResponse();
		List<Car> list = new ArrayList<Car>();
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

		list.add(car1);
		list.add(car2);

		response.setCars(list);
		response.setCode(Util.OK_CODE);
		response.setMessage(Util.OK_MESSAGE);

		when(carServiceMock.getCars()).thenReturn(list);

		mockMvc.perform(get("/car/list")).andExpect(status().isOk())
				.andExpect(content().contentType(Util.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.code", is(200)))
				.andExpect(jsonPath("$.message", is("OK"))).andExpect(jsonPath("$.cars", hasSize(2)))
				.andExpect(jsonPath("$.cars[0].id", is(1))).andExpect(jsonPath("$.cars[0].model", is("Rav4")))
				.andExpect(jsonPath("$.cars[1].id", is(2))).andExpect(jsonPath("$.cars[1].model", is("Yaris")));

		// Verify that the method is called only once
		verify(carServiceMock, times(1)).getCars();
		// Ensure that no other methods of our mock obj are called during test
		verifyNoMoreInteractions(carServiceMock);
	}

}
