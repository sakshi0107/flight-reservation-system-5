package com.cg.flightreservationsystem.excetion;

import java.util.Date;

public class ErrorMessages  {
	private Date timestamp;
	private String message;
	private String url;
	
	
	
	public ErrorMessages(Date timestamp,  String message, String url) {
	
		this.timestamp = timestamp;
		this.message = message;
		this.url = url;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
}
