package com.backendchallenge.handler;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.backendchallenge.bean.Weather;
import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.constants.ResponseMessage;
import com.backendchallenge.enums.ErrorMessageEnum;
import com.backendchallenge.exception.WeatherChallengeException;
import com.backendchallenge.service.WeatherService;
/**
 * 
 * @author lapto
 *
 */
@Component
public class WeatherHandlerImpl implements WeatherHandler {

	@Autowired
	private WeatherService weatherService;
	
	/**
	 * Method is used to get current weather
	 */
	@Override
	public WsResponse GetCurrentWeatherData(Optional<String> location) throws WeatherChallengeException {
		final WsResponse response = new WsResponse();
		if (!location.isPresent()) {
			throw new WeatherChallengeException(ErrorMessageEnum.APP001.name(), ErrorMessageEnum.APP001.value());
		}
		Weather data= weatherService.getWeather(location.get());
		response.setMessage(ResponseMessage.SUCCESS);
		response.setStatus((data == null) ? HttpStatus.NO_CONTENT.value() : HttpStatus.OK.value());
		response.setData(data);
		return response;

	}

	
}
