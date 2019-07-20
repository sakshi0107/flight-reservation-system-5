package com.cg.flightreservationsystem.controller;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.FlightApplication;
import com.cg.flightreservationsystem.bean.FlightRouteBean;

import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightRouteOperationService;
import com.cg.flightreservationsystem.utility.Exceptions;

@RestController
@RequestMapping(value = "/admin")
public class FlightRouteController {

	@Autowired
	private FlightRouteOperationService flightRouteOperationService;
	Logger log = org.slf4j.LoggerFactory.getLogger(FlightApplication.class);
	FlightRouteBean flightRouteBean = new FlightRouteBean();

	/*
	 * method to add route details
	 */
	
	@PostMapping(value = "/addRoute", consumes = "application/json", produces = "application/json")
	public String add(@RequestBody FlightRouteBean flightRouteBean) throws FRSException {
		log.info("adding");
		flightRouteBean.setCurrentTime(LocalDateTime.now());
		String result = null;
		if(flightRouteBean.getSource().contentEquals(flightRouteBean.getDestination())) {
			throw new FRSException(Exceptions.CITY_EQUALS);
		}
		else {
		try {
			result = flightRouteOperationService.add(flightRouteBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.CITY_INCORRECT);
			
		}
		}
		log.info("adding done");
		return result;

	}

	/*
	 * method to delete route details
	 */

	@DeleteMapping(value = "/deleteRoute", consumes = "application/json", produces = "application/json")
	public boolean delete(@RequestBody FlightRouteBean flightRouteBean) {
		boolean result = false;
		if(flightRouteBean==null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		}
		else {
		try {
			result = flightRouteOperationService.delete(flightRouteBean);
		} catch (FRSException exception) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		}
		return result;
	}
	
	@PutMapping(value = "/viewRoute", consumes = "application/json", produces = "application/json")
	public boolean view(@RequestBody FlightRouteBean flightRouteBean) {
		boolean result = false;
		if(flightRouteBean==null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		}
		else {
		try {
			result = flightRouteOperationService.view(flightRouteBean);
		} catch (FRSException exception) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		}
		return result;
	}
	
	public void setFlightRouteOperationService(FlightRouteOperationService flightRouteOperationService) {
		this.flightRouteOperationService = flightRouteOperationService;
	}

}
