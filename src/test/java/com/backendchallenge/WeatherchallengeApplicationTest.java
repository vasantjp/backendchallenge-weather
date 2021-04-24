package com.backendchallenge;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import com.backendchallenge.bean.Weather;
import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.controller.WeatherController;
import com.backendchallenge.handler.WeatherHandler;

@WebMvcTest(WeatherController.class)

class WeatherchallengeApplicationTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private WeatherHandler service;

	@MockBean
	private RestTemplate restTemplate;

	@Test
	void test() {

	}

	@Test
	public void testWeather_whenGetWeather_thenReturnJsonObject() throws Exception {
		WsResponse response = new WsResponse();
		Weather weather = new Weather();
		weather.setPressure(10250);
		weather.setTemp(125.5);
		weather.setUmbrella(false);
		response.setData(weather);
		response.setStatus(200);
		response.setMessage("SUCCESS");
		when(service.GetCurrentWeatherData(Optional.of("Berlin"))).thenReturn(response);

		RequestBuilder request = MockMvcRequestBuilders.get("/weather/api/v1/current?location=Berlin")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"data\":{\"umbrella\":false,\"temp\":125.5,\"pressure\":10250},\"message\":\"SUCCESS\",\"status\":200}"))
				.andReturn();

	}

	@Test
	public void testWeather_when_City_Not_Found_thenReturnError() throws Exception {
		WsResponse response = new WsResponse();
		response.setStatus(500);
		response.setErrorMessage("\"404 Not Found: [{\\\"cod\\\":\\\"404\\\",\\\"message\\\":\\\"city not found\\\"}]");

		when(service.GetCurrentWeatherData(Optional.of("test"))).thenReturn(response);

		RequestBuilder request = MockMvcRequestBuilders.get("/weather/api/v1/current?location=test")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mvc.perform(request).andExpect(status().isOk()).andExpect(content().json(
				"{\"errorMessage\":\"\\\"404 Not Found: [{\\\\\\\"cod\\\\\\\":\\\\\\\"404\\\\\\\",\\\\\\\"message\\\\\\\":\\\\\\\"city not found\\\\\\\"}]\",\"status\":500}"))
				.andReturn();

	}

}
