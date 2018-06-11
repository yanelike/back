package com.bz.spring.springcloud.backend.exception;


public class ResourceNotFoundException extends Exception {

	private static final long serialVersionUID = -9079454849611061074L;

	public ResourceNotFoundException() {
		super("Ops not found");
	}

	public ResourceNotFoundException(final String message) {
		super(message + " not found");
	}

}