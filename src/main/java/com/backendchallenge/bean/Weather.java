package com.backendchallenge.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.backendchallenge.enums.WeatherConditionsEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather implements Serializable {

	private static final long serialVersionUID = 7406210628182440902L;
	
	private boolean umbrella;
	private double temp;
	private int pressure;

	public double getTemp() {
		return temp;
	}

	@JsonProperty("pressure")
	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	
	public boolean getUmbrella() {
		return umbrella;
	}
	
	@JsonProperty("umbrella")
	public void setUmbrella(boolean umbrella) {
		this.umbrella = umbrella;
	}

	

	@JsonProperty("weather")
	public void setWeather(List<Map<String, Object>> weatherEntries) {
		Map<String, Object> weather = weatherEntries.get(0);
		setUmbrella(WeatherConditionsEnum.isType(weather.get("main").toString()));
	}

	@JsonProperty("pressure")
	public int getPressure() {
		return pressure;
	}

	@JsonProperty("temp")
	public void setTemp(double temp) {
		this.temp = temp;
	}
	
	@JsonProperty("main")
	public void setCoord(Map<String, Object> main) {
		setTemp((double) main.get("temp"));
		setPressure((int)main.get("pressure"));
		
	}
	
	
	
}