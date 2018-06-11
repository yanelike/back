package com.bz.spring.springcloud.backend.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bz.spring.springcloud.backend.service.dto.ExceptionResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final ResourceNotFoundException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setCode("404");
		return error;
	}
	
	@ExceptionHandler(UnauthorizedException.class)
	@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
	public @ResponseBody ExceptionResponse handleUnauthorized(final UnauthorizedException exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setCode("401");
		return error;
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ExceptionResponse handleException(final Exception exception,
			final HttpServletRequest request) {

		ExceptionResponse error = new ExceptionResponse();
		error.setMessage(exception.getMessage());
		error.callerURL(request.getRequestURI());
		error.setCode("500");
		return error;
	}

}
