package com.cg.flightreservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightScheduleOperationService;
import com.cg.flightreservationsystem.utility.Exceptions;

@RestController
@RequestMapping(value = "/admin")
public class FlightScheduleController {

	@Autowired
	private FlightScheduleOperationService scheduleService;
	FlightScheduleBean flightScheduleBean = new FlightScheduleBean();

	/*
	 * method to add schedule details
	 */
	@PostMapping(value = "/addSchedule", consumes = "application/json", produces = "application/json")
	public String addSchedule(@RequestBody FlightScheduleBean flightScheduleBean) {
		String result = null;
		if(flightScheduleBean.getArrivalTime().equals(flightScheduleBean.getDepartureTime())) 
		{
			throw new FRSException(Exceptions.TIME_EQUALS);
		}
		else {
		try {
			result = scheduleService.add(flightScheduleBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		}
		return result;
	}

	/*
	 * method to delete schedule details
	 */
	@DeleteMapping(value = "/deleteSchedule", consumes = "application/json", produces = "application/json")
	public boolean delete(@RequestBody FlightScheduleBean flightScheduleBean) {
		boolean result = false;
		try {
			result = scheduleService.delete(flightScheduleBean);
		} catch (FRSException e) {
			throw new FRSException(Exceptions.CONNECTION_EXCEPTION);
		}
		return result;
	}

	public void setScheduleService(FlightScheduleOperationService scheduleService) {
		this.scheduleService = scheduleService;
	}
}
