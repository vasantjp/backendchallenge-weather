package com.backendchallenge.enums;
/**
 * 
 * @author lapto
 *
 */
public enum WeatherConditionsEnum {
	 Thunderstorm, Drizzle,Rain;

	WeatherConditionsEnum() {
    }

    public String getStatus() {
        return this.name();
    }
    
    public static boolean isType(String type) {
    	WeatherConditionsEnum[] types = WeatherConditionsEnum.values();
        for (WeatherConditionsEnum t : types) {
            if (t.name().equalsIgnoreCase(type)) {
                return true;
            }
        }
        return false;
    }
    
}
