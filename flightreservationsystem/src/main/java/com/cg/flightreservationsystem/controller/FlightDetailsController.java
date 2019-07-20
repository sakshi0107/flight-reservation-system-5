package com.cg.flightreservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightDetailsOperationService;
import com.cg.flightreservationsystem.utility.Exceptions;

@RestController
@RequestMapping(value = "/admin")
public class FlightDetailsController {
	/*
	 * method to add flight details
	 */
	@Autowired
	private FlightDetailsOperationService flightDetailsOperationService;
	FlightDetailsBean flightDetailsBean = new FlightDetailsBean();

	@RequestMapping(value = "/addFlight", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
	public String add(@RequestBody FlightDetailsBean flightDetailsBean) {
		String flag = null;
		if(flightDetailsBean.getCapacity()<=100) {
			throw new FRSException(Exceptions.CAPACITY_EXCEPTION);
		}
		try {
			flag = flightDetailsOperationService.add(flightDetailsBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		return flag;
	}

	/*
	 * method to delete flight details
	 */
	@RequestMapping(value = "/deleteFlight", method = RequestMethod.DELETE, consumes = "application/json", produces = "application/json")
	public boolean delete(@RequestBody FlightDetailsBean flightDetailsBean) {
		boolean result = false;
		try {
			result = flightDetailsOperationService.delete(flightDetailsBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		return result;
	}

	public void setFlightDetailsOperationService(FlightDetailsOperationService flightDetailsOperationService) {
		this.flightDetailsOperationService = flightDetailsOperationService;
	}

}
