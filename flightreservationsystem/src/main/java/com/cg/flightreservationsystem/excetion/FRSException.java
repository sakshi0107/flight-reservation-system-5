package com.cg.flightreservationsystem.excetion;

public class FRSException extends RuntimeException{
	/**
	 * common exception class
	 */
	private static final long serialVersionUID = 1L;
	private  int httpStatus;

	public FRSException(String message) {
		super(message);
	}

	public FRSException(int httpStatus, String message) {
		super();
		this.httpStatus = httpStatus;
	}

	public int getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(int httpStatus) {
		this.httpStatus = httpStatus;
	}
	
	
}
