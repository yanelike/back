package com.bz.spring.springcloud.backend.exception;

public class UnauthorizedException  extends Exception{
	private static final long serialVersionUID = -9079454849611061074L;

	public UnauthorizedException() {
		super();
	}

	public UnauthorizedException(final String message) {
		super(message);
	}
}
