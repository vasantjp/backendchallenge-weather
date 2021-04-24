package com.backendchallenge.exception;


/**
 * @author 
 *
 * Custom Exception class for com.WeatherChallengeException.
 */
public class WeatherChallengeException extends Exception {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorMessge;

    private String errorCode;


    public WeatherChallengeException(String errorCode, String errorMessge) {
        this.errorCode = errorCode;
        this.errorMessge = errorMessge;
    }

    public WeatherChallengeException(String s, String errorMessge, String errorCode) {
        super(s);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public WeatherChallengeException(String s, Throwable throwable, String errorMessge, String errorCode) {
        super(s, throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public WeatherChallengeException(Throwable throwable, String errorMessge, String errorCode) {
        super(throwable);
        this.errorMessge = errorMessge;
        this.errorCode = errorCode;
    }

    public WeatherChallengeException(Throwable e) {
        super(e);
    }



    public String getErrorMessge() {
        return errorMessge;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
