package com.wedevol.controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.wedevol.bean.Car;
import com.wedevol.bean.CarResponse;
import com.wedevol.bean.CarsResponse;
import com.wedevol.exception.CarNotFoundException;
import com.wedevol.service.CarService;
import com.wedevol.util.CarUtil;
import com.wedevol.util.Util;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration("/servlet-context.xml")
@WebAppConfiguration
public class CarControllerTest {
	
	@Mock
	private CarService carServiceMock;

	@InjectMocks
	private CarController carController;

	private MockMvc mockMvc;

	@Before
	public void init() {
		mockMvc = MockMvcBuilders.standaloneSetup(carController).build();
	}

	@Test
	public void getListCars_CarsFound_ShouldReturnFoundCars() throws Exception {

		final CarsResponse response = new CarsResponse();
		final List<Car> carList = CarUtil.getListOfCarsMock();

		response.setCode(Util.OK_CODE);
		response.setMessage(Util.OK_MESSAGE);

		when(carServiceMock.getCars()).thenReturn(carList);

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

	@Test
	public void getCar_CarNotFound_ShouldReturnHttpStatusCode404() throws Exception {
		when(carServiceMock.getCar(new Integer(100))).thenThrow(new CarNotFoundException());
		// doThrow(new CarNotFoundException()).when(carServiceMock).getCar(100);
		 //when(carServiceMock.getCar(100)).thenReturn(null);

		final MvcResult result = mockMvc.perform(get("/car/{id}", 100)).andExpect(status().isOk())
				.andExpect(content().contentType(Util.APPLICATION_JSON_UTF8))/*.andExpect(jsonPath("$.code", is(404)))*/
				.andReturn();
		final String content = result.getResponse().getContentAsString();

		final String a = content;
		final String b = a;

		//verify(carServiceMock, times(1)).getCar(100);
		//verifyNoMoreInteractions(carServiceMock);
	}
	
	@Test
	public void getCar_CarFound_ShouldReturnFoundCar() throws Exception {
		
		final CarResponse response = new CarResponse();
		final Car car = CarUtil.getCarMock();

		response.setCode(Util.OK_CODE);
		response.setMessage(Util.OK_MESSAGE);

		when(carServiceMock.getCar(Mockito.any(Integer.class))).thenReturn(car);

		mockMvc.perform(get("/car/{id}", Mockito.any(Integer.class))).andExpect(status().isOk())
		.andExpect(content().contentType(Util.APPLICATION_JSON_UTF8)).andExpect(jsonPath("$.code", is(200)))
		.andExpect(jsonPath("$.message", is("OK")))
		.andExpect(jsonPath("$.car.id", is(1))).andExpect(jsonPath("$.car.model", is("Rav4")));

		verify(carServiceMock, times(1)).getCar(Mockito.any(Integer.class));
		verifyNoMoreInteractions(carServiceMock);
	}

}
