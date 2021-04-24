package com.backendchallenge.enums;

/**
 * @author 
 *
 * Error codes and messages
 */
public enum ErrorMessageEnum {

    APP001("Please Provide location name"),;
	private String value;

	ErrorMessageEnum(String error) {
		this.value = error;
	}

	public String value() {
		return value;
	}
}
