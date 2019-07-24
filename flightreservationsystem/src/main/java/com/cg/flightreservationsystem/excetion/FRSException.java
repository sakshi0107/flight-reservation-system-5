package com.cg.flightreservationsystem.excetion;

public class FRSException extends RuntimeException {
	/**
	 * common exception class
	 */
	private static final long serialVersionUID = 1L;

	public FRSException(String message) {
		super(message);
	}

}
