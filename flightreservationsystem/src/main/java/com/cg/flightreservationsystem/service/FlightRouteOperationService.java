package com.cg.flightreservationsystem.service;

import java.sql.SQLException;

import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightRouteOperationService {
	/**
	 * method declaration to adds route details
	 * 
	 * @param route
	 * @return String
	 * @throws FRSException
	 * @throws SQLException
	 */

	public String add(FlightRouteBean flightRouteBean) throws FRSException;

	/**
	 * method declaration to delete the route details
	 * 
	 * @param flight
	 * @return FlightDTO
	 * @throws FRSException
	 */
	public boolean delete(FlightRouteBean flightRouteBean) throws FRSException;

	public boolean view(FlightRouteBean flightRouteBean)throws FRSException;
}
