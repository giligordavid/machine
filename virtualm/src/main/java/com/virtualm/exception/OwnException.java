package com.virtualm.exception;

public class OwnException extends RuntimeException {
	private String message;

	public OwnException(String message, long remaining) {
		this.message = message;
	}
	
	public OwnException(String message) {
		this.message = message;
	}


	@Override
	public String getMessage() {
		return message;
	}

}
