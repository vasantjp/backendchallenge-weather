package com.backendchallenge.handler;

import java.util.Optional;

import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.exception.WeatherChallengeException;

public interface WeatherHandler {

	WsResponse GetCurrentWeatherData(Optional<String> location) throws WeatherChallengeException;
	
}
