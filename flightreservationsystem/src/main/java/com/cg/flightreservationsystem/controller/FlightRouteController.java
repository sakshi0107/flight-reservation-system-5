package com.cg.flightreservationsystem.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public FlightRouteBean add(@Valid @RequestBody FlightRouteBean flightRouteBean) {
		log.info("adding");
		if (flightRouteBean.getSource() == null || flightRouteBean.getDestination() == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {

			FlightRouteBean result = null;
			if (flightRouteBean.getSource().equalsIgnoreCase(flightRouteBean.getDestination())) {
				throw new FRSException(Exceptions.CITY_EQUALS);
			} else {
				try {
					result = flightRouteOperationService.add(flightRouteBean);
					System.out.println("added ");
				} catch (FRSException e) {
					throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
				}
			}

			log.info("adding done");
			return result;
		}
	}

	/*
	 * method to delete route details
	 */

	@DeleteMapping(value = "/deleteRoute", consumes = "application/json", produces = "application/json")
	public FlightRouteBean delete(@RequestBody FlightRouteBean flightRouteBean) {
		log.info("deleting");
		FlightRouteBean result = null;
		if (flightRouteBean.getRouteId() <= 0) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {
			try {
				result = flightRouteOperationService.delete(flightRouteBean);
			} catch (FRSException exception) {
				throw new FRSException(Exceptions.FOREIGN_KEY_CONSTRAINT);
			}
		}
		log.info("deleting done ");
		return result;
	}

	@PostMapping(value = "/viewRoute", consumes = "application/json", produces = "application/json")
	public List<FlightRouteBean> view(@RequestBody FlightRouteBean flightRouteBean) {
		List<FlightRouteBean> route = new ArrayList<FlightRouteBean>();
		log.info("fetching all details");
		if (flightRouteBean == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {
			try {
				route = flightRouteOperationService.view(flightRouteBean);
			} catch (FRSException exception) {
				throw new FRSException(Exceptions.ID_INVALID);
			}
		}
		log.info("list is displayed");
		return route;
	}

	public void setFlightRouteOperationService(FlightRouteOperationService flightRouteOperationService) {
		this.flightRouteOperationService = flightRouteOperationService;
	}

}
