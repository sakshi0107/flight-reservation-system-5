package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightScheduleOperationService {
	/**
	 * adds schedule details
	 * 
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public FlightScheduleBean add(FlightScheduleBean flightScheduleBean) throws FRSException;

	/**
	 * deletes plane details
	 * 
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightScheduleBean delete(FlightScheduleBean flightScheduleBean) throws FRSException;
}
