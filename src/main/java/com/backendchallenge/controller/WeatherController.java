package com.backendchallenge.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.exception.WeatherChallengeException;
import com.backendchallenge.handler.WeatherHandler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "/openweather", description = "openweather Map")
@RequestMapping(value = "/weather")
public class WeatherController {
	@Autowired
	private WeatherHandler weatherHandler;

	/**
	 * 
	 * @param location
	 * @return
	 * @throws WeatherChallengeException
	 */
	@GetMapping("/api/v1/current")
	@ApiOperation(value = "API to get current weather")
	public ResponseEntity<WsResponse> GetCurrentWeather(@RequestParam(name = "location") String location)
			throws WeatherChallengeException {
		final WsResponse response = weatherHandler.GetCurrentWeatherData(Optional.of(location));
		return new ResponseEntity<WsResponse>(response, HttpStatus.OK);
	}

}
