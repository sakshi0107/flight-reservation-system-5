package com.cg.flightreservationsystem.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.FlightApplication;
import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightScheduleOperationService;
import com.cg.flightreservationsystem.utility.Exceptions;

@RestController
@RequestMapping(value = "/admin")
public class FlightScheduleController {

	@Autowired
	private FlightScheduleOperationService scheduleService;
	Logger log = org.slf4j.LoggerFactory.getLogger(FlightApplication.class);
	FlightScheduleBean flightScheduleBean = new FlightScheduleBean();

	/*
	 * method to add schedule details
	 */
	@PostMapping(value = "/addSchedule", consumes = "application/json", produces = "application/json")
	public FlightScheduleBean addSchedule(@RequestBody FlightScheduleBean flightScheduleBean) {
		log.info("adding");
		FlightScheduleBean result = null;
		if (flightScheduleBean == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {
			if (flightScheduleBean.getArrivalTime().equals(flightScheduleBean.getDepartureTime())) {
				throw new FRSException(Exceptions.TIME_EQUALS);
			} else {
				try {
					result = scheduleService.add(flightScheduleBean);
				} catch (FRSException e) {
					throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
				}
			}
			log.info("adding done");
			return result;
		}
	}

	/*
	 * method to delete schedule details
	 */
	@DeleteMapping(value = "/deleteSchedule", consumes = "application/json", produces = "application/json")
	public FlightScheduleBean delete(@RequestBody FlightScheduleBean flightScheduleBean) {
		log.info("deleting");
		FlightScheduleBean result = null;
		if (flightScheduleBean == null) {
			throw new FRSException(Exceptions.EMPTY_LIST);
		} else {
			try {
				result = scheduleService.delete(flightScheduleBean);
			} catch (FRSException e) {
				throw new FRSException(Exceptions.ID_INVALID);
			}
			log.info("deleting done");
			return result;
		}
	}

	public void setScheduleService(FlightScheduleOperationService scheduleService) {
		this.scheduleService = scheduleService;
	}
}
