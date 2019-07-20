package com.cg.flightreservationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightreservationsystem.bean.FlightDetailsBean;
import com.cg.flightreservationsystem.dao.FlightDetailsDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightDetailsOperationService;
@Service
public class FlightDetailsOperationServiceImpl implements FlightDetailsOperationService{

	@Autowired
	private FlightDetailsDao flightDetailsDao;
	
	public void setFlightDetailsDao(FlightDetailsDao flightDetailsDao) {
		this.flightDetailsDao = flightDetailsDao;
	}
	
	/**
	 * method to add flight details
	 */
	public String add(FlightDetailsBean flightDetailsBean) throws FRSException {
		
		return flightDetailsDao.addFlight(flightDetailsBean);
	}

	/**
	 * method to delete flight details
	 */
	public boolean delete(FlightDetailsBean flightDetailsBean) throws FRSException {
		
		return flightDetailsDao.deleteFlight(flightDetailsBean);
	}
	

}
