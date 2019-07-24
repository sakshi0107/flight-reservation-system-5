package com.cg.flightreservationsystem.dao;

import java.util.List;

import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.excetion.FRSException;

public interface FlightRouteDao {
	/**
	 * add route details
	 * 
	 * @param flightRouteBean
	 * @return String
	 * @throws FRSException
	 */
	public FlightRouteBean addRoute(FlightRouteBean flightRouteBean) throws FRSException;

	/**
	 * delete route details in the flight
	 * 
	 * @param flightRouteBean
	 * @return boolean
	 * @throws FRSException
	 */
	public FlightRouteBean deleteRoute(FlightRouteBean flightRouteBean) throws FRSException;

	public List<FlightRouteBean> viewRoute(FlightRouteBean flightRouteBean) throws FRSException;
}
