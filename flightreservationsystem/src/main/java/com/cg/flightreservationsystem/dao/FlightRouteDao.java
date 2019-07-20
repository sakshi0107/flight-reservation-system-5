package com.cg.flightreservationsystem.dao;

import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightRouteDao {
	/**
	 * add route details 
	 * @param flightRouteBean
	 * @return String
	 * @throws FRSException
	 */
	public String addRoute(FlightRouteBean flightRouteBean) throws FRSException;

	/**
	 * delete route details in the flight
	 * @param flightRouteBean
	 * @return boolean
	 * @throws FRSException
	 */
	public boolean deleteRoute(FlightRouteBean flightRouteBean) throws FRSException;
	public boolean viewRoute(FlightRouteBean flightRouteBean) throws FRSException;
}
