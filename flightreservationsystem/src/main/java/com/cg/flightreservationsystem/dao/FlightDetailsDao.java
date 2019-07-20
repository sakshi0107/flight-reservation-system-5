package com.cg.flightreservationsystem.dao;

import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightDetailsDao {
	/**
	 * adds plane details
	 * @param flightDetailsBean
	 * @return String
	 * @throws FRSException
	 */
	public String addFlight(FlightDetailsBean flightDetailsBean) throws FRSException;

	/**
	 * delete plane details
	 * @param flightDetailsBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteFlight(FlightDetailsBean flightDetailsBean) throws FRSException;

}
