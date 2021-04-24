package com.backendchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.backendchallenge.bean.Weather;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * @author lapto
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	private RestTemplate restTemp;


	@Value("${weather.url}")
	private String url;
	
	@Value("${weather.apikey}")
	private String apikey;

	@Override
	public Weather getWeather(String location) {
		
       String uri=url+"?q="+location+"&mode=json&appid="+apikey;
       ResponseEntity<String> resp= restTemp.exchange(uri, HttpMethod.GET, null, String.class);
       System.out.println(resp.getBody());
		ObjectMapper mapper = new ObjectMapper();
		Weather weather = null;
		try {
			weather = mapper.readValue(resp.getBody(), Weather.class);
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return weather;
	}
}
