package com.backendchallenge.intercepter;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.backendchallenge.bean.WsResponse;
import com.backendchallenge.enums.ErrorMessageEnum;
import com.backendchallenge.exception.WeatherChallengeException;

/**
 * 
 * @author lapto
 *
 */
@ControllerAdvice
public class RestExceptionHandler {
	/**
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(WeatherChallengeException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody WsResponse handleResourceNotFound(final WeatherChallengeException exception,
			final HttpServletRequest request) {
		final WsResponse error = new WsResponse();
		error.setErrorMessage(exception.getErrorMessge());
		error.setErrorCode(exception.getErrorCode());
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		return error;
	}

	/**
	 * 
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody WsResponse handleException(final Exception exception, final HttpServletRequest request) {

		final WsResponse error = new WsResponse();
		error.setErrorMessage(exception.getMessage());
		error.setErrorCode(exception.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
		return error;
	}

}