package com.cg.flightreservationsystem.dao;

import java.sql.SQLException;
import java.text.ParseException;

import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightScheduleDao {

	/**
	 * adds schedule details to the flight table
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public String addSchedule(FlightScheduleBean flightScheduleBean) throws FRSException;

	/**
	 * delete schedule details to the flight table
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteSchedule(FlightScheduleBean flightScheduleBean) throws FRSException;

}
