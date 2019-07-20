package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightDetailsOperationService {
	/**
	 * adds the airplane details to the database
	 * 
	 * @param flight
	 * @return FlightDTO
	 * @throws FRSException
	 */
	public String add(FlightDetailsBean flightDetailsBean) throws FRSException;

	/**
	 * deletes the airplane details to the database
	 * 
	 * @param flight
	 * @return FlightDTO
	 * @throws FRSException
	 * 
	 */
	public boolean delete(FlightDetailsBean flightDetailsBean) throws FRSException;

}
