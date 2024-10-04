package com.mqtt.app.exceptions;

public class OTPExpiredException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1921489518215148358L;
	private String message;

	public OTPExpiredException(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
