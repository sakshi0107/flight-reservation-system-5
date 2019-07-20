package com.cg.flightreservationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightreservationsystem.bean.FlightScheduleBean;
import com.cg.flightreservationsystem.dao.FlightScheduleDao;
import com.cg.flightreservationsystem.excetion.FRSException;
import com.cg.flightreservationsystem.service.FlightScheduleOperationService;
@Service
public class FlightScheduleOperationServiceImpl implements FlightScheduleOperationService {
	@Autowired
	private FlightScheduleDao flightScheduleDao;

	/**
	 * method to add schedule details
	 * @param flightScheduleBean
	 * @return String
	 * @throws FRSException
	 */
	public String add(FlightScheduleBean flightScheduleBean) throws FRSException {
		
		return flightScheduleDao.addSchedule(flightScheduleBean);
	}

	/**
	 * method to delete plane details
	 * @param flightScheduleBean
	 * @return boolean
	 * @throws FRSException
	 */

	public boolean delete(FlightScheduleBean flightScheduleBean) throws FRSException {
	
		return flightScheduleDao.deleteSchedule(flightScheduleBean);
	}
	
	
	
	
}
