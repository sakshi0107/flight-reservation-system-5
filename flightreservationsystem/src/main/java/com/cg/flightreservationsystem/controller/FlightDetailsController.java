package com.cg.flightreservationsystem.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.FlightApplication;
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
	Logger log = org.slf4j.LoggerFactory.getLogger(FlightApplication.class);
	FlightDetailsBean flightDetailsBean = new FlightDetailsBean();

	@PostMapping(value = "/addFlight", consumes = "application/json", produces = "application/json")
	public FlightDetailsBean add(@RequestBody FlightDetailsBean flightDetailsBean) {
		log.info("adding");
		FlightDetailsBean result = null;
		if (flightDetailsBean == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {
			if (flightDetailsBean.getCapacity() <= 100) {
				throw new FRSException(Exceptions.CAPACITY_EXCEPTION);
			}
			try {
				result = flightDetailsOperationService.add(flightDetailsBean);
			} catch (FRSException e) {
				throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
			}
			log.info("adding done");
			return result;
		}
	}

	/*
	 * method to delete flight details
	 */
	@DeleteMapping(value = "/deleteFlight", consumes = "application/json", produces = "application/json")
	public FlightDetailsBean delete(@RequestBody FlightDetailsBean flightDetailsBean) {
		log.info("deleting");
		FlightDetailsBean result = null;
		if (flightDetailsBean == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		}
		try {
			result = flightDetailsOperationService.delete(flightDetailsBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.FOREIGN_KEY_CONSTRAINT);
		}
		log.info("deleting done");
		return result;
	}

	public void setFlightDetailsOperationService(FlightDetailsOperationService flightDetailsOperationService) {
		this.flightDetailsOperationService = flightDetailsOperationService;
	}

}
