package com.cg.flightreservationsystem.excetion;

import java.sql.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
@RestController
public class ExceptionHandler {
	@org.springframework.web.bind.annotation.ExceptionHandler(FRSException.class)
	public ResponseEntity<ErrorMessages> badRequestException(FRSException exception, WebRequest request){
		ErrorMessages messages = new ErrorMessages(new Date(0), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(messages, HttpStatus.BAD_REQUEST);

	}
	
	public ResponseEntity<ErrorMessages> notFoundException(FRSException exception, WebRequest request){
		ErrorMessages messages = new ErrorMessages(new Date(0), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(messages, HttpStatus.NOT_FOUND);
		
	}	
	public ResponseEntity<ErrorMessages> notFoundException2(FRSException exception, WebRequest request){
		ErrorMessages messages = new ErrorMessages(new Date(0), exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(messages, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}	
	
}
	