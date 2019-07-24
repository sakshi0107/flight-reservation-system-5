package com.cg.flightreservationsystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.flightreservationsystem.bean.FlightRouteBean;
import com.cg.flightreservationsystem.dao.FlightRouteDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightRouteOperationService;

@Service
public class FlightRouteOperationServiceImpl implements FlightRouteOperationService {

	@Autowired
	private FlightRouteDao flightRouteDao;

	/**
	 * method to add route details
	 * 
	 * @param flightRouteDao
	 * @return
	 */
	public FlightRouteBean add(FlightRouteBean flightRouteBean) throws FRSException {

		return flightRouteDao.addRoute(flightRouteBean);
	}

	public void setFlightRouteDao(FlightRouteDao flightRouteDao) {
		this.flightRouteDao = flightRouteDao;
	}

	/**
	 * method to delete route details
	 * 
	 * @param flightRouteBean
	 */
	public FlightRouteBean delete(FlightRouteBean flightRouteBean) throws FRSException {

		return flightRouteDao.deleteRoute(flightRouteBean);
	}

	public List<FlightRouteBean> view(FlightRouteBean flightRouteBean) throws FRSException {
		return flightRouteDao.viewRoute(flightRouteBean);
	}

}
