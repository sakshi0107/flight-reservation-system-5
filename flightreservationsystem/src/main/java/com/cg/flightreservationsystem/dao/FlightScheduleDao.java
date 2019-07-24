package com.cg.flightreservationsystem.dao;

import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightScheduleDao {

	/**
	 * adds schedule details to the flight table
	 * 
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public FlightScheduleBean addSchedule(FlightScheduleBean flightScheduleBean) throws FRSException;

	/**
	 * delete schedule details to the flight table
	 * 
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightScheduleBean deleteSchedule(FlightScheduleBean flightScheduleBean) throws FRSException;

}
