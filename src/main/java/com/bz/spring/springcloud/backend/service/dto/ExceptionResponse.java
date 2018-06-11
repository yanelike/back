package com.bz.spring.springcloud.backend.service.dto;

public class ExceptionResponse {

	private String message;
	private String code;
	private String requestedURI;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void callerURL(final String requestedURI) {
		this.requestedURI = requestedURI;
	}
}
