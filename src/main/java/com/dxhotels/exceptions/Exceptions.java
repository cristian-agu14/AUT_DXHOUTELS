package com.dxhotels.exceptions;

public class Exceptions extends AssertionError {

	private static final long serialVersionUID = 1L;
	
	public static final String VALUE_TOTAL_ERROR = "Error!!! The values TOTAL are not equal";

	public Exceptions(String message, Throwable testErrorException) {
		super(message, testErrorException);
	}

	public Exceptions(String message) {
		super(message);
	}

}
